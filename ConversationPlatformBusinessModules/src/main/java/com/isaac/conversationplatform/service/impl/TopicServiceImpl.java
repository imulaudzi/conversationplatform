package com.isaac.conversationplatform.service.impl;

import com.isaac.conversationplatform.dao.TopicRepository;
import com.isaac.conversationplatform.dao.model.Topic;
import com.isaac.conversationplatform.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * Created by isaac on 2016/12/01.
 */
@Service
public class TopicServiceImpl implements TopicService {
    @Autowired
    TopicRepository topicRepository;

    @Override
    public Topic postTopic(Topic topic) {

        topic.setPostedOnDate(LocalDateTime.now());
        return topicRepository.save(topic);
    }
}
