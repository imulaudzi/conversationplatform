package com.isaac.conversationplatform.web.controller;

import com.isaac.conversationplatform.dao.model.Topic;
import com.isaac.conversationplatform.dto.PostMessageStatus;
import com.isaac.conversationplatform.generatedAvro.TopicRequest;
import com.isaac.conversationplatform.generated.TopicResponse;
import com.isaac.conversationplatform.service.TopicService;
import com.isaac.conversationplatform.transformation.TopicTransformer;
import com.isaac.conversationplatform.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/post", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public TopicResponse postTopic(@RequestBody TopicRequest topicRequest) {

        Topic topic = topicTransformer.topicFromXsdObject(topicRequest);
        PostMessageStatus messageStatus = topicService.postTopic(topic);
        return this.topicResponse(messageStatus);
    }

    private TopicResponse topicResponse(PostMessageStatus postMessageStatus) {
        TopicResponse topicResponse = new TopicResponse();
        topicResponse.setResponseCodeMessage(ResponseUtil.responseFromEnum(postMessageStatus.getReturnCodeLookUp()));
        return topicResponse;
    }
}
