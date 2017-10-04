package com.yueserver.service;

import com.yueserver.enity.noenity.IssueForMct;
import com.yueserver.enity.noenity.IssueForUser;
import com.yueserver.enity.noenity.ResultBean;

public interface SolveIssueInterface {

    ResultBean<Boolean> SolveIssueForMct(IssueForMct issueForMct);
    ResultBean<Boolean> SolveIssueForUser(IssueForUser issueForUser);

}
