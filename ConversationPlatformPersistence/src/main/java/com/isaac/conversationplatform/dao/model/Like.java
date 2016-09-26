package com.isaac.conversationplatform.dao.model;

/**
 * Created by isaac on 2016/09/07.
 */
public class Like {

    private UserDetails userId;
    private Topic topicId;
    private Comment commentId;

    public UserDetails getUserId() {
        return userId;
    }

    public void setUserId(UserDetails userId) {
        this.userId = userId;
    }

    public Topic getTopicId() {
        return topicId;
    }

    public void setTopicId(Topic topicId) {
        this.topicId = topicId;
    }

    public Comment getCommentId() {
        return commentId;
    }

    public void setCommentId(Comment commentId) {
        this.commentId = commentId;
    }
}
