package com.isaac.conversationplatform.service.impl;

import com.google.common.hash.Hashing;
import com.isaac.conversationplatform.dao.TopicRepository;
import com.isaac.conversationplatform.dao.UserInfoRepository;
import com.isaac.conversationplatform.dao.model.Topic;
import com.isaac.conversationplatform.dao.model.UserInfo;
import com.isaac.conversationplatform.dto.PostMessageStatus;
import com.isaac.conversationplatform.service.TopicService;
import com.isaac.conversationplatform.util.ReturnCodeLookUp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by isaac on 2016/12/01.
 */
@Service
public class TopicServiceImpl implements TopicService {
    @Autowired
    TopicRepository topicRepository;
    @Autowired
    private UserInfoRepository userInfoRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(TopicService.class);

    @Override
    public PostMessageStatus postTopic(Topic topic) {
        PostMessageStatus messageStatus = new PostMessageStatus();
        if (isUserRegistered(topic.getPostedBy().getUserId())) {
            if (isUserActiveOrPending(topic.getPostedBy().getUserId())) {
                String duplicateHash = this.calculateDuplicateHash(topic);
                topic.setDuplicateHash(duplicateHash);
                LOGGER.info("Duplicate hash for this topic: [{}]",duplicateHash);

                List<Topic> duplicateTopics = this.listDuplicates(duplicateHash);
                if(duplicateTopics.isEmpty()) {
                    createTopic(topic);
                    messageStatus.setReturnCodeLookUp(ReturnCodeLookUp.SUCCESS);
                } else {
                    LOGGER.info("Topic is a duplicate: [{}]",duplicateHash);
                    messageStatus.setReturnCodeLookUp(ReturnCodeLookUp.DUPLICATE_TOPIC);
                }

            } else {

                LOGGER.info("User is InActive");
                messageStatus.setReturnCodeLookUp(ReturnCodeLookUp.USER_IS_INACTIVE);
            }

        } else {
            LOGGER.info(String.format("User with User ID : %s ", topic.getPostedBy().getUserId()));
            messageStatus.setReturnCodeLookUp(ReturnCodeLookUp.USER_NOT_REGISTERED);
        }
        return messageStatus;
    }


    private Topic createTopic(Topic topic) {
        topic.setPostedOnDate(LocalDateTime.now());
        return topicRepository.save(topic);
    }

    private Boolean isUserRegistered(Long userId) {
        Boolean isRegistered = false;

        if (userId != null) {
            LOGGER.info(String.format("isUserRegistered:: Searching User with User ID : %s ", userId));
            isRegistered = userInfoRepository.exists(userId);
        }
        return isRegistered;
    }

    private Boolean isUserActiveOrPending(Long userId) {
        Boolean isUserActiveOrPending = true;
        if (userId != null) {
            LOGGER.info(String.format("isUserActiveOrPending:: Searching User with User ID : %s ", userId));

            UserInfo userInfo = userInfoRepository.isUserActiveOrPending(userId);
            if (userInfo == null) {
                isUserActiveOrPending = false;
            }
        }
        return isUserActiveOrPending;
    }

    public String calculateDuplicateHash(Topic topic) {
        StringBuilder hashBuilder = new StringBuilder();
        hashBuilder.append(topic.getPostedBy().getUserId().toString());
        hashBuilder.append(topic.getContent());
        hashBuilder.append(topic.getTopicDescription());

        return Hashing.sha256().hashBytes(hashBuilder.toString().getBytes()).toString();
    }

    private List<Topic> listDuplicates(String duplicateHash) {
        return topicRepository.listByDuplicateHash(duplicateHash);
    }

    @Override
    public int multipy(int originalNum) {
        return originalNum * 3;
    }
}
