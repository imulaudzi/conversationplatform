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
    private Long commentId;
    //TODO content is either text, audio, photo or video
    @Column(name = "content")
    private String content;
    @Column(name = "posted_by")
    private UserDetails postedBy;
    @Column(name = "topic_id")
    private Topic topicId;
    @Column(name = "posted_date_time")
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

    public LocalDateTime getPostedOnDate() {
        return postedOnDate;
    }

    public void setPostedOnDate(LocalDateTime postedOnDate) {
        this.postedOnDate = postedOnDate;
    }
}
