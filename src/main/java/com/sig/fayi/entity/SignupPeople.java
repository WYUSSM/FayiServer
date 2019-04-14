package com.sig.fayi.entity;

import java.util.Date;

public class SignupPeople {
    private int signupId;
    private int signupactivityId;
    private int userId;
    private Date signUpTime;
    private String signInFlag;
    private Date signInTime;

    public int getSignupId() {
        return signupId;
    }

    public void setSignupId(int signupId) {
        this.signupId = signupId;
    }

    public int getSignupactivityId() {
        return signupactivityId;
    }

    public void setSignupactivityId(int signupactivityId) {
        this.signupactivityId = signupactivityId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getSignUpTime() {
        return signUpTime;
    }

    public void setSignUpTime(Date signUpTime) {
        this.signUpTime = signUpTime;
    }

    public String getSignInFlag() {
        return signInFlag;
    }

    public void setSignInFlag(String signInFlag) {
        this.signInFlag = signInFlag;
    }

    public Date getSignInTime() {
        return signInTime;
    }

    public void setSignInTime(Date signInTime) {
        this.signInTime = signInTime;
    }
}
