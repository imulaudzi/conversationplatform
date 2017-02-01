package com.isaac.conversationplatform.transformation;

import com.isaac.conversationplatform.dao.model.Topic;
import com.isaac.conversationplatform.generatedAvro.TopicRequest;

/**
 * Created by isaac on 2016/12/06.
 */
public interface TopicTransformer {
    public Topic topicFromXsdObject (TopicRequest topicRequest);
}
