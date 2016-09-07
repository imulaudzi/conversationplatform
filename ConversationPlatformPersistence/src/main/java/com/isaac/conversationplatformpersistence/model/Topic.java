package com.isaac.conversationplatformpersistence.model;

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

    public Long getTopicId() {
        return topicId;
    }

    public void setTopicId(Long topicId) {
        this.topicId = topicId;
    }

    public String getTopicDescription() {
        return topicDescription;
    }

    public void setTopicDescription(String topicDescription) {
        this.topicDescription = topicDescription;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public UserDetails getPostedBy() {
        return postedBy;
    }

    public void setPostedBy(UserDetails postedBy) {
        this.postedBy = postedBy;
    }

    public Date getPostedOnDate() {
        return postedOnDate;
    }

    public void setPostedOnDate(Date postedOnDate) {
        this.postedOnDate = postedOnDate;
    }
}
