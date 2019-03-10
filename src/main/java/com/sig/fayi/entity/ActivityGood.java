package com.sig.fayi.entity;

import java.util.Date;

public class ActivityGood {
    private int goodId;
    private int commentId;
    private int gooder;
    private int gooder1;
    private Date good_time;
    private String good_read;

    public int getGoodId() {
        return goodId;
    }

    public void setGoodId(int goodId) {
        this.goodId = goodId;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public int getGooder() {
        return gooder;
    }

    public void setGooder(int gooder) {
        this.gooder = gooder;
    }

    public int getGooder1() {
        return gooder1;
    }

    public void setGooder1(int gooder1) {
        this.gooder1 = gooder1;
    }

    public Date getGood_time() {
        return good_time;
    }

    public void setGood_time(Date good_time) {
        this.good_time = good_time;
    }

    public String getGood_read() {
        return good_read;
    }

    public void setGood_read(String good_read) {
        this.good_read = good_read;
    }
}
