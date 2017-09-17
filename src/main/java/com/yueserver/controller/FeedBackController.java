package com.yueserver.controller;

import com.yueserver.adaper.conver.JsonConverter;
import com.yueserver.enity.nodao.IssueForMct;
import com.yueserver.enity.nodao.IssueForUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping(value = "/feed")
public class FeedBackController {

    @ResponseBody
    @RequestMapping(value = "/push/merchant", method = RequestMethod.POST)
    public boolean PushIssueForMerchant(@ModelAttribute IssueForMct issueForMct) {
        issueForMct.setQuestime(new Date());
        return true;
    }

    @ResponseBody
    @RequestMapping(value = "/push/user", method = RequestMethod.POST)
    public boolean PushIssueForUser(@ModelAttribute IssueForUser issueForUser) {
        issueForUser.setQuestime(new Date());
        return true;
    }

    @ResponseBody
    @RequestMapping(value = "/receive/merchant", method = {RequestMethod.POST, RequestMethod.GET})
    public String IssueMerchantMap() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 3; i ++) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("no", i);
            hashMap.put("issuetype", i);
            hashMap.put("mctname", i);
            hashMap.put("mctemail", i);
            hashMap.put("quesname", i);
            hashMap.put("questime", String.valueOf(new Date()));
            hashMap.put("solve", "");
            arrayList.add(hashMap);
        }
        String test = new JsonConverter().setMessage(arrayList);
        return test;
    }

    @ResponseBody
    @RequestMapping(value = "/receive/user", method = RequestMethod.POST)
    public HashMap<String, Object> IssueUserMap() {
        return null;
    }

}
