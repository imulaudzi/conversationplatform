package com.isaac.conversationplatform.dao.model;

import javax.persistence.*;
import java.time.LocalDateTime;


/**
 * Created by isaac on 2016/09/07.
 */
@Entity
@Table(name = "COMMENT")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "COMMENT_ID")
    private Long commentId;
    //TODO content is either text, audio, photo or video
    @Column(name = "CONTENT")
    private String content;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private UserInfo postedBy;


    @ManyToOne
    @JoinColumn(name = "TOPIC_ID")
    private Topic topicId;

    @Column(name = "POSTED_DATE_TIME")
    private LocalDateTime postedOnDate;

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

    public UserInfo getPostedBy() {
        return postedBy;
    }

    public void setPostedBy(UserInfo postedBy) {
        this.postedBy = postedBy;
    }

    public Topic getTopicId() {
        return topicId;
    }

    public void setTopicId(Topic topicId) {
        this.topicId = topicId;
    }

    public LocalDateTime getPostedOnDate() {
        return postedOnDate;
    }

    public void setPostedOnDate(LocalDateTime postedOnDate) {
        this.postedOnDate = postedOnDate;
    }
}
