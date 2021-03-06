package com.isaac.conversationplatform.dao.model;

import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by isaac on 2016/09/06.
 */
@Entity
@Table(name = "TOPIC")
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TOPIC_ID")
    private Long topicId;
    @Column(name = "TOPIC_DESC")
    private String topicDescription;
    //TODO content is either text, audio, photo or video
    @Column(name = "CONTENT")
    private String content;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private UserInfo postedBy;
    @Column(name = "DUPLICATE_HASH")
    private String duplicateHash;
    @Column(name = "POSTED_DATE_TIME")
    private LocalDateTime postedOnDate;

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

    public UserInfo getPostedBy() {
        return postedBy;
    }

    public void setPostedBy(UserInfo postedBy) {
        this.postedBy = postedBy;
    }

    public LocalDateTime getPostedOnDate() {
        return postedOnDate;
    }

    public void setPostedOnDate(LocalDateTime postedOnDate) {
        this.postedOnDate = postedOnDate;
    }

    public String getDuplicateHash() {
        return duplicateHash;
    }

    public void setDuplicateHash(String duplicateHash) {
        this.duplicateHash = duplicateHash;
    }
}
