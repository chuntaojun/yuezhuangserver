package com.yueserver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
@RequestMapping(value = "/feed")
public class FeedBackController {

    @ResponseBody
    @RequestMapping(value = "/merchant", method = RequestMethod.POST)
    public HashMap<String, String> IssueMerchantMap() {
        return null;
    }

    @ResponseBody
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public HashMap<String, String> IssueUserMap() {
        return null;
    }

}
