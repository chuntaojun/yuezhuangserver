package com.yueserver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/solve/issue")
public class SolveIssueController {


    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public boolean SolveIssueUser() {
        return false;
    }

    @RequestMapping(value = "/merchant", method = RequestMethod.POST)
    public boolean SolveIssueMerchant() {
        return false;
    }

}
