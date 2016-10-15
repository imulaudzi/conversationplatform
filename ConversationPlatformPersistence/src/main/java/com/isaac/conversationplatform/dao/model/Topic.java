package com.isaac.conversationplatform.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

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
    @Column(name = "POSTED_BY")
    private UserInfo postedBy;
    @Column(name = "POSTED_DATE_TIME")
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

    public UserInfo getPostedBy() {
        return postedBy;
    }

    public void setPostedBy(UserInfo postedBy) {
        this.postedBy = postedBy;
    }

    public Date getPostedOnDate() {
        return postedOnDate;
    }

    public void setPostedOnDate(Date postedOnDate) {
        this.postedOnDate = postedOnDate;
    }
}
