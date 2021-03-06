package com.sig.fayi.entity;

import java.util.Date;

public class Organization {
    private int id;
    private String headImage;
    private String backgroundImage;
    private String phone;
    private String people_name;
    private String organizationName;
    private String proofImage;
    private String handIdCard;
    private String positiveImage;
    private String negativeImage;
    private String address;
    private String signature;
    private String password;
    private String email;
    private double volunteer_time;
    private int peopleNum;
    private String flag;
    private int examineUser;
    private Date examine_time;
    private Date register_time;
    private String demo;

    public Organization(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHeadImage() {
        return headImage;
    }

    public void setHeadImage(String headImage) {
        this.headImage = headImage;
    }

    public String getBackgroundImage() {
        return backgroundImage;
    }

    public void setBackgroundImage(String backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPeople_name() {
        return people_name;
    }

    public void setPeople_name(String people_name) {
        this.people_name = people_name;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getProofImage() {
        return proofImage;
    }

    public void setProofImage(String proofImage) {
        this.proofImage = proofImage;
    }

    public String getHandIdCard() {
        return handIdCard;
    }

    public void setHandIdCard(String handIdCard) {
        this.handIdCard = handIdCard;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getVolunteer_time() {
        return volunteer_time;
    }

    public void setVolunteer_time(double volunteer_time) {
        this.volunteer_time = volunteer_time;
    }

    public int getPeopleNum() {
        return peopleNum;
    }

    public void setPeopleNum(int peopleNum) {
        this.peopleNum = peopleNum;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public int getExamineUser() {
        return examineUser;
    }

    public void setExamineUser(int examineUser) {
        this.examineUser = examineUser;
    }

    public Date getExamine_time() {
        return examine_time;
    }

    public void setExamine_time(Date examine_time) {
        this.examine_time = examine_time;
    }

    public Date getRegister_time() {
        return register_time;
    }

    public void setRegister_time(Date register_time) {
        this.register_time = register_time;
    }

    public String getDemo() {
        return demo;
    }

    public void setDemo(String demo) {
        this.demo = demo;
    }
}
