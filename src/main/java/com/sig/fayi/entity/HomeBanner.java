package com.sig.fayi.entity;

import java.util.Date;

public class HomeBanner {
    private int id;
    private String image;
    private String url;
    private String demo;
    private String flag;//是否是广告
    private Date time;

    public HomeBanner(int id,String image,String url,String demo,Boolean flag,String time){

    }
    public HomeBanner(){

    }
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setDemo(String demo) {
        this.demo = demo;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String getDemo() {
        return demo;
    }

    public Date getTime() {
        return time;
    }

//    @Override
//    public String toString() {
//        return "HomeBanner{" +
//                "id=" + id +
//                ", image=" + image + '\'' +
//                ", url=" + url + '\'' +
//                ", demo=" + demo + '\'' +
//                ", flag='" + flag + '\'' +
//                ", time=" + time +
//                '}';
//    }
}
