package com.yueserver.enity;

import java.util.Date;

public class Post {

    private int postno;
    private String posttitle;
    private String postmain;
    private Date posttime;
    private int postlikenum;
    private int postcomnum;
    private int postsharenum;

    public Post(){}

    public int getPostno() {
        return postno;
    }

    public void setPostno(int postno) {
        this.postno = postno;
    }

    public String getPosttitle() {
        return posttitle;
    }

    public void setPosttitle(String posttitle) {
        this.posttitle = posttitle;
    }

    public String getPostmain() {
        return postmain;
    }

    public void setPostmain(String postmain) {
        this.postmain = postmain;
    }

    public Date getPosttime() {
        return posttime;
    }

    public void setPosttime(Date posttime) {
        this.posttime = posttime;
    }

    public int getPostlikenum() {
        return postlikenum;
    }

    public void setPostlikenum(int postlikenum) {
        this.postlikenum = postlikenum;
    }

    public int getPostcomnum() {
        return postcomnum;
    }

    public void setPostcomnum(int postcomnum) {
        this.postcomnum = postcomnum;
    }

    public int getPostsharenum() {
        return postsharenum;
    }

    public void setPostsharenum(int postsharenum) {
        this.postsharenum = postsharenum;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postno=" + postno +
                ", posttitle='" + posttitle + '\'' +
                ", postmain='" + postmain + '\'' +
                ", posttime=" + posttime +
                ", postlikenum=" + postlikenum +
                ", postcomnum=" + postcomnum +
                ", postsharenum=" + postsharenum +
                '}';
    }
}
