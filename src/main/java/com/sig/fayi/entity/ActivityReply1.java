package com.sig.fayi.entity;

import java.util.Date;

public class ActivityReply1 {
    private int replyId;
    private int commentId;
    private int responder;
    private int responder1;
    private String reply_conent;
    private Date reply_time;
    private String reply_read;

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

    public int getResponder() {
        return responder;
    }

    public void setResponder(int responder) {
        this.responder = responder;
    }

    public int getResponder1() {
        return responder1;
    }

    public void setResponder1(int responder1) {
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

    public String getReply_read() {
        return reply_read;
    }

    public void setReply_read(String reply_read) {
        this.reply_read = reply_read;
    }
}
