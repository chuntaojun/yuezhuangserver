package com.yueserver.enity;

import java.sql.Timestamp;

public class PostComment {

    private long postcomno;
    private String postcommain;
    private Timestamp postcomtime;
    private String postcompic;

    public PostComment(){}

    public long getPostcomno() {
        return postcomno;
    }

    public void setPostcomno(long postcomno) {
        this.postcomno = postcomno;
    }

    public String getPostcommain() {
        return postcommain;
    }

    public void setPostcommain(String postcommain) {
        this.postcommain = postcommain;
    }

    public Timestamp getPostcomtime() {
        return postcomtime;
    }

    public void setPostcomtime(Timestamp postcomtime) {
        this.postcomtime = postcomtime;
    }

    public String getPostcompic() {
        return postcompic;
    }

    public void setPostcompic(String postcompic) {
        this.postcompic = postcompic;
    }
}
