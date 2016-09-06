package com.isaac.conversationplatformpersistence;

import java.util.Date;

/**
 * Created by isaac on 2016/09/06.
 */
public class Topic {

    private Long topicId;
    private String topicDescription;
    //TODO content is either text, audio, photo or video
    private String content;
    private UserDetails postedBy;
    //TODO must use JODA date api
    private Date postedOnDate;
}
