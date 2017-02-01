package com.isaac.conversationplatform.activator;

import com.isaac.conversationplatform.dao.model.Topic;
import com.isaac.conversationplatform.dto.PostMessageStatus;
import com.isaac.conversationplatform.generatedAvro.TopicRequest;
import com.isaac.conversationplatform.service.TopicService;
import com.isaac.conversationplatform.transformation.TopicTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;

/**
 * Created by isaac on 2017/01/29.
 */
@Component
public class MessageProcessor {

    @Autowired
    private TopicService topicService;
    @Autowired
    private TopicTransformer topicTransformer;

    @ServiceActivator
    public void processMessage(TopicRequest topicRequest) {
        Topic topic = topicTransformer.topicFromXsdObject(topicRequest);
        PostMessageStatus messageStatus = topicService.postTopic(topic);
    }
}
