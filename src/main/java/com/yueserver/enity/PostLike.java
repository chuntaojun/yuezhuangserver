package com.yueserver.enity;

import java.sql.Date;

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
