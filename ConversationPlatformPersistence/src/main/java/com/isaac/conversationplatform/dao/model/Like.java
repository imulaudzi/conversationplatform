package com.isaac.conversationplatform.dao.model;

import javax.persistence.*;

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

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private UserInfo userId;

    @JoinColumn(name = "TOPIC_ID")
    @ManyToOne
    private Topic topicId;

    @JoinColumn(name = "COMMENT_ID")
    @ManyToOne
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
