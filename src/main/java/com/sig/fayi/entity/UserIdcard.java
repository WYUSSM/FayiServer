package com.sig.fayi.entity;

import java.util.Date;

public class UserIdcard {
    private int idcard;
    private String positiveImage;
    private String negativeImage;
    private String flag;
    private String examineUser;
    private Date examine_time;
    private Date upload_time;

    public int getIdcard() {
        return idcard;
    }

    public void setIdcard(int idcard) {
        this.idcard = idcard;
    }

    public String getPositiveImage() {
        return positiveImage;
    }

    public void setPositiveImage(String positiveImage) {
        this.positiveImage = positiveImage;
    }

    public String getNegativeImage() {
        return negativeImage;
    }

    public void setNegativeImage(String negativeImage) {
        this.negativeImage = negativeImage;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getExamineUser() {
        return examineUser;
    }

    public void setExamineUser(String examineUser) {
        this.examineUser = examineUser;
    }

    public Date getExamine_time() {
        return examine_time;
    }

    public void setExamine_time(Date examine_time) {
        this.examine_time = examine_time;
    }

    public Date getUpload_time() {
        return upload_time;
    }

    public void setUpload_time(Date upload_time) {
        this.upload_time = upload_time;
    }
}
