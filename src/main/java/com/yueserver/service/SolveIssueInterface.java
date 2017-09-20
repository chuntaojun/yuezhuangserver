package com.yueserver.service;

import com.yueserver.enity.nodao.IssueForMct;
import com.yueserver.enity.nodao.IssueForUser;
import com.yueserver.enity.nodao.ResultBean;

public interface SolveIssueInterface {

    ResultBean<Boolean> SolveIssueForMct(IssueForMct issueForMct);
    ResultBean<Boolean> SolveIssueForUser(IssueForUser issueForUser);

}
