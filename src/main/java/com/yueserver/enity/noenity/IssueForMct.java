package com.yueserver.enity.noenity;

import java.util.Date;

public class IssueForMct {

    private int issueno;
    private int issuetype;
    private String mctname;
    private String mctemail;
    private String quesname;
    private Date questime;
    private String solve;

    public int getIssueno() {
        return issueno;
    }

    public void setIssueno(int issueno) {
        this.issueno = issueno;
    }

    public int getIssuetype() {
        return issuetype;
    }

    public void setIssuetype(int issuetype) {
        this.issuetype = issuetype;
    }

    public String getMctname() {
        return mctname;
    }

    public void setMctname(String mctname) {
        this.mctname = mctname;
    }

    public String getMctemail() {
        return mctemail;
    }

    public void setMctemail(String mctemail) {
        this.mctemail = mctemail;
    }

    public String getQuesname() {
        return quesname;
    }

    public void setQuesname(String quesname) {
        this.quesname = quesname;
    }

    public Date getQuestime() {
        return questime;
    }

    public void setQuestime(Date questime) {
        this.questime = questime;
    }

    public String getSolve() {
        return solve;
    }

    public void setSolve(String solve) {
        this.solve = solve;
    }

    @Override
    public String toString() {
        return "IssueForMct{" +
                "issueno=" + issueno +
                ", issuetype=" + issuetype +
                ", mctname='" + mctname + '\'' +
                ", mctemail='" + mctemail + '\'' +
                ", quesname='" + quesname + '\'' +
                ", questime=" + questime +
                ", solve='" + solve + '\'' +
                '}';
    }
}
