package com.isaac.conversationplatform.transformation.impl;

import com.isaac.conversationplatform.dao.model.Topic;
import com.isaac.conversationplatform.dao.model.UserInfo;
import com.isaac.conversationplatform.generatedAvro.TopicRequest;
import com.isaac.conversationplatform.transformation.TopicTransformer;
import org.springframework.stereotype.Service;

/**
 * Created by isaac on 2016/12/06.
 */
@Service
public class TopicTransformerImpl implements TopicTransformer {
    @Override
    public Topic topicFromXsdObject(TopicRequest topicRequest) {
        Topic topic = new Topic();
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(topicRequest.getPostedBy());
        topic.setTopicDescription(topicRequest.getTopicDescription().toString());
        topic.setContent(topicRequest.getContent().toString());
        topic.setPostedBy(userInfo);
        return topic;
    }
}
