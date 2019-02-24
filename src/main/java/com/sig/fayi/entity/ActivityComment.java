package com.sig.fayi.entity;

import java.util.Date;
import java.util.List;

public class ActivityComment {
    private int id;
    private int activityId;
    private User commentor;
    private Organization commentor1;
    private String content;
    private Date time;
    private int goodCount;
    private List<ActivityGood> activityGoodList;
    private int replyCount;
    private List<ActivityReply> activityReplyList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }

    public User getCommentor() {
        return commentor;
    }

    public void setCommentor(User commentor) {
        this.commentor = commentor;
    }

    public Organization getCommentor1() {
        return commentor1;
    }

    public void setCommentor1(Organization commentor1) {
        this.commentor1 = commentor1;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getGoodCount() {
        return goodCount;
    }

    public void setGoodCount(int goodCount) {
        this.goodCount = goodCount;
    }

    public List<ActivityGood> getActivityGoodList() {
        return activityGoodList;
    }

    public void setActivityGoodList(List<ActivityGood> activityGoodList) {
        this.activityGoodList = activityGoodList;
    }

    public int getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(int replyCount) {
        this.replyCount = replyCount;
    }

    public List<ActivityReply> getActivityReplyList() {
        return activityReplyList;
    }

    public void setActivityReplyList(List<ActivityReply> activityReplyList) {
        this.activityReplyList = activityReplyList;
    }
}
