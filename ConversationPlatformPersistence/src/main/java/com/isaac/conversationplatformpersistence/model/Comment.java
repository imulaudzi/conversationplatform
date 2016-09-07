package com.isaac.conversationplatformpersistence.model;

import java.util.Date;

/**
 * Created by isaac on 2016/09/07.
 */
public class Comment {

    private Long commentId;
    //TODO content is either text, audio, photo or video
    private String content;
    private UserDetails postedBy;
    private Topic topicId;
    //TODO must use JODA date api
    private Date postedOnDate;

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
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

    public Topic getTopicId() {
        return topicId;
    }

    public void setTopicId(Topic topicId) {
        this.topicId = topicId;
    }

    public Date getPostedOnDate() {
        return postedOnDate;
    }

    public void setPostedOnDate(Date postedOnDate) {
        this.postedOnDate = postedOnDate;
    }
}
