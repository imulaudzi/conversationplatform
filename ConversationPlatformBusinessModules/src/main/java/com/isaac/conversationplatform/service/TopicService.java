package com.isaac.conversationplatform.service;

import com.isaac.conversationplatform.dao.model.Topic;
import com.isaac.conversationplatform.dto.PostMessageStatus;

/**
 * Created by isaac on 2016/12/01.
 */
public interface TopicService {

    PostMessageStatus postTopic(Topic topic);
    int multipy(int originalNum);
}
