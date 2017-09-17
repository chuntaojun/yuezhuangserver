package com.yueserver.enity;

import java.sql.Date;

public class Post {

    private int postno;
    private String posttitle;
    private String postmain;
    private Date posttime;

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
}
