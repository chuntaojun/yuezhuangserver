package com.yueserver.bean;

import java.sql.Date;
import java.sql.Timestamp;

public class PostFav {

    private int postfavno;
    private Date postfavtime;

    public PostFav(){}

    public int getPostfavno() {
        return postfavno;
    }

    public void setPostfavno(int postfavno) {
        this.postfavno = postfavno;
    }

    public Date getPostfavtime() {
        return postfavtime;
    }

    public void setPostfavtime(Date postfavtime) {
        this.postfavtime = postfavtime;
    }
}
