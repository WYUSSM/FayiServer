package com.sig.fayi.entity;

import java.util.Date;

public class OrganizationPeople {
    private int orgPeopleId;
    private int organizationId;
    private int userId;
    private Date apply_time;
    private String flag;
    private Date signUp_time;

    public int getOrgPeopleId() {
        return orgPeopleId;
    }

    public void setOrgPeopleId(int orgPeopleId) {
        this.orgPeopleId = orgPeopleId;
    }

    public int getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(int organizationId) {
        this.organizationId = organizationId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getApply_time() {
        return apply_time;
    }

    public void setApply_time(Date apply_time) {
        this.apply_time = apply_time;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Date getSignUp_time() {
        return signUp_time;
    }

    public void setSignUp_time(Date signUp_time) {
        this.signUp_time = signUp_time;
    }
}
