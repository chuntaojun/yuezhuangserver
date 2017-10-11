package com.yueserver.enity;

import java.util.Date;

public class Post {

    private int postno;
    private String posttitle;
    private String postmain;
    private Date posttime;
    private int usrno;
    private int posttypeno;
    private int postlikenum;
    private int postcomnum;
    private int postfavnum;

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

    public int getUsrno() {
        return usrno;
    }

    public void setUsrno(int usrno) {
        this.usrno = usrno;
    }

    public int getPosttypeno() {
        return posttypeno;
    }

    public void setPosttypeno(int posttypeno) {
        this.posttypeno = posttypeno;
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

    public int getPostfavnum() {
        return postfavnum;
    }

    public void setPostfavnum(int postfavnum) {
        this.postfavnum = postfavnum;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postno=" + postno +
                ", posttitle='" + posttitle + '\'' +
                ", postmain='" + postmain + '\'' +
                ", posttime=" + posttime +
                ", usrno=" + usrno +
                ", posttypeno=" + posttypeno +
                ", postlikenum=" + postlikenum +
                ", postcomnum=" + postcomnum +
                ", postfavnum=" + postfavnum +
                '}';
    }
}
