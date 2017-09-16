package com.yueserver.bean;

import java.sql.Date;
import java.sql.Timestamp;

public class PostLike {

    private long postlikeno;
    private Date postliketime;

    public PostLike(){}

    public long getPostlikeno() {
        return postlikeno;
    }

    public void setPostlikeno(long postlikeno) {
        this.postlikeno = postlikeno;
    }

    public Date getPostliketime() {
        return postliketime;
    }

    public void setPostliketime(Date postliketime) {
        this.postliketime = postliketime;
    }
}
