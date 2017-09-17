package com.yueserver.bean;

public class PostVideo {

    private int postvidno;
    private String postvidurl;
    private int postvidlocation;

    public PostVideo(){}

    public int getPostvidno() {
        return postvidno;
    }

    public void setPostvidno(int postvidno) {
        this.postvidno = postvidno;
    }

    public String getPostvidurl() {
        return postvidurl;
    }

    public void setPostvidurl(String postvidurl) {
        this.postvidurl = postvidurl;
    }

    public int getPostvidlocation() {
        return postvidlocation;
    }

    public void setPostvidlocation(int postvidlocation) {
        this.postvidlocation = postvidlocation;
    }
}
