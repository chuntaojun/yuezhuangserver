package com.yueserver.service;

import com.yueserver.enity.nodao.IssueForMct;
import com.yueserver.enity.nodao.IssueForUser;

public interface SolveIssueInterface {

    boolean SolveIssueForMct(IssueForMct issueForMct);
    boolean SolveIssueForUser(IssueForUser issueForUser);

}
