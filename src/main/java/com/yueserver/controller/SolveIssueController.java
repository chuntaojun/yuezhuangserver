package com.yueserver.controller;

import com.yueserver.enity.nodao.IssueForMct;
import com.yueserver.enity.nodao.IssueForUser;
import com.yueserver.service.SolveIssueInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping(value = "/admin/feed/solve")
public class SolveIssueController {

    @Autowired
    @Resource(name = "SolveIssueService")
    private SolveIssueInterface solveIssueInterface;

    @ResponseBody
    @RequestMapping(value = "/merchant", method = RequestMethod.POST)
    public boolean SolveIssueMerchant(@ModelAttribute IssueForMct iuuseForMct, int ID) {
        return solveIssueInterface.SolveIssueForMct(iuuseForMct);
    }

    @ResponseBody
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public boolean SolveIssueUser(@ModelAttribute IssueForUser issueForUser, int ID) {
        return solveIssueInterface.SolveIssueForUser(issueForUser);
    }

}
