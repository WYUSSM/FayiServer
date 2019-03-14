package com.sig.fayi.entity;

import java.util.Date;

public class SimpleVoluntary {
    private int id;
    private int organizationId;
    private Date siginUpStartTime;
    private Date siginUpEndTime;
    private Date startTime;
    private Date endTime;
    private String chargeName;
    private String chargePhone;
    private int peopleNum;
    private int signUpNum;
    private String address;
    private String addressLongitude;
    private String addressLatitude;
    private String voluntaryMore;
    private String voluntaryCover;
    private String title;
    private Date createTime;
    private String province;
    private String city;
    private String district;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(int organizationId) {
        this.organizationId = organizationId;
    }

    public Date getSiginUpStartTime() {
        return siginUpStartTime;
    }

    public void setSiginUpStartTime(Date siginUpStartTime) {
        this.siginUpStartTime = siginUpStartTime;
    }

    public Date getSiginUpEndTime() {
        return siginUpEndTime;
    }

    public void setSiginUpEndTime(Date siginUpEndTime) {
        this.siginUpEndTime = siginUpEndTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getChargeName() {
        return chargeName;
    }

    public void setChargeName(String chargeName) {
        this.chargeName = chargeName;
    }

    public String getChargePhone() {
        return chargePhone;
    }

    public void setChargePhone(String chargePhone) {
        this.chargePhone = chargePhone;
    }

    public int getPeopleNum() {
        return peopleNum;
    }

    public void setPeopleNum(int peopleNum) {
        this.peopleNum = peopleNum;
    }

    public int getSignUpNum() {
        return signUpNum;
    }

    public void setSignUpNum(int signUpNum) {
        this.signUpNum = signUpNum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddressLongitude() {
        return addressLongitude;
    }

    public void setAddressLongitude(String addressLongitude) {
        this.addressLongitude = addressLongitude;
    }

    public String getAddressLatitude() {
        return addressLatitude;
    }

    public void setAddressLatitude(String addressLatitude) {
        this.addressLatitude = addressLatitude;
    }

    public String getVoluntaryMore() {
        return voluntaryMore;
    }

    public void setVoluntaryMore(String voluntaryMore) {
        this.voluntaryMore = voluntaryMore;
    }

    public String getVoluntaryCover() {
        return voluntaryCover;
    }

    public void setVoluntaryCover(String voluntaryCover) {
        this.voluntaryCover = voluntaryCover;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }
}
