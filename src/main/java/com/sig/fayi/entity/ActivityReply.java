package com.sig.fayi.entity;

import java.util.Date;

public class ActivityReply {
    private int replyId;
    private int commentId;
    private User responder;
    private Organization responder1;
    private String reply_conent;
    private Date reply_time;

    public int getReplyId() {
        return replyId;
    }

    public void setReplyId(int replyId) {
        this.replyId = replyId;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public User getResponder() {
        return responder;
    }

    public void setResponder(User responder) {
        this.responder = responder;
    }

    public Organization getResponder1() {
        return responder1;
    }

    public void setResponder1(Organization responder1) {
        this.responder1 = responder1;
    }

    public String getReply_conent() {
        return reply_conent;
    }

    public void setReply_conent(String reply_conent) {
        this.reply_conent = reply_conent;
    }

    public Date getReply_time() {
        return reply_time;
    }

    public void setReply_time(Date reply_time) {
        this.reply_time = reply_time;
    }
}
