package com.sig.fayi.entity;

import java.util.Date;

public class ActivityComment1 {
    private int commentId;
    private int activityId;
    private int commentor;
    private int commentor1;
    private String content;
    private Date time;
    private int goodCount;
    private int replyCount;
    private String comment_read;

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }

    public int getCommentor() {
        return commentor;
    }

    public void setCommentor(int commentor) {
        this.commentor = commentor;
    }

    public int getCommentor1() {
        return commentor1;
    }

    public void setCommentor1(int commentor1) {
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

    public int getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(int replyCount) {
        this.replyCount = replyCount;
    }

    public String getComment_read() {
        return comment_read;
    }

    public void setComment_read(String comment_read) {
        this.comment_read = comment_read;
    }
}
