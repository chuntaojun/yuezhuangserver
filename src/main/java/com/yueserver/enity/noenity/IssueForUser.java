package com.yueserver.enity.noenity;

import java.util.Date;

public class IssueForUser {

    private int issueno;
    private int issuetype;
    private String usrname;
    private String account;
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

    public String getUsrname() {
        return usrname;
    }

    public void setUsrname(String usrname) {
        this.usrname = usrname;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
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
        return "IssueForUser{" +
                "issueno=" + issueno +
                ", issuetype=" + issuetype +
                ", usrname='" + usrname + '\'' +
                ", account='" + account + '\'' +
                ", quesname='" + quesname + '\'' +
                ", questime=" + questime +
                ", solve='" + solve + '\'' +
                '}';
    }
}
