package com.yueserver.controller;

import com.yueserver.enity.nodao.IssueForMct;
import com.yueserver.enity.nodao.IssueForUser;
import com.yueserver.enity.nodao.ResultBean;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
@RequestMapping(value = "/feed")
public class FeedBackController {

    @ResponseBody
    @RequestMapping(value = "/push/merchant", method = RequestMethod.POST)
    public ResultBean<Boolean> PushIssueForMerchant(@ModelAttribute IssueForMct issueForMct) {
        issueForMct.setQuestime(new Date());
        return new ResultBean<>(true);
    }

    @ResponseBody
    @RequestMapping(value = "/push/user", method = RequestMethod.POST)
    public ResultBean<Boolean> PushIssueForUser(@ModelAttribute IssueForUser issueForUser) {
        issueForUser.setQuestime(new Date());
        return new ResultBean<>(false);
    }

    @ResponseBody
    @RequestMapping(value = "/receive/merchant", method = {RequestMethod.POST, RequestMethod.GET})
    public ResultBean<Map> IssueMerchantMap() {
        return new ResultBean<>();
    }

    @ResponseBody
    @RequestMapping(value = "/receive/user", method = RequestMethod.POST)
    public ResultBean<Map> IssueUserMap() {
        return new ResultBean<>();
    }

}
