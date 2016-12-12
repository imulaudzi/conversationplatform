package com.isaac.conversationplatform.web.controller;

import com.isaac.conversationplatform.dao.model.Topic;
import com.isaac.conversationplatform.generated.TopicRequest;
import com.isaac.conversationplatform.service.TopicService;
import com.isaac.conversationplatform.transformation.TopicTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by isaac on 2016/12/06.
 */
@RestController
@RequestMapping(value = "/topic")
public class TopicController {

    @Autowired
    private TopicService topicService;
    @Autowired
    private TopicTransformer topicTransformer;

    @RequestMapping(value = "/post", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_XML_VALUE})
    public void postTopic(@RequestBody TopicRequest topicRequest) {

        Topic topic = topicTransformer.topicFromXsdObject(topicRequest);
        topicService.postTopic(topic);
    }
}
