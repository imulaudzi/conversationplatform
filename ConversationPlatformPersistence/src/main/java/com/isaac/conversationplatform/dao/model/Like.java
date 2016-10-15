package com.isaac.conversationplatform.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by isaac on 2016/09/07.
 */
@Entity
@Table(name = "LIKES")
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "LIKE_ID")
    private Long like_id;
    @Column(name = "USER_ID")
    private UserInfo userId;
    @Column(name = "TOPIC_ID")
    private Topic topicId;
    @Column(name = "COMMENT_ID")
    private Comment commentId;

    public UserInfo getUserId() {
        return userId;
    }

    public void setUserId(UserInfo userId) {
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

    public Long getLike_id() {
        return like_id;
    }

    public void setLike_id(Long like_id) {
        this.like_id = like_id;
    }
}
