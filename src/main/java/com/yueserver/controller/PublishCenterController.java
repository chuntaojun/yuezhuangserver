package com.yueserver.controller;

import com.yueserver.bean.Notice;
import com.yueserver.service.PublishServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Secured("ROLE_ADMIN")
@Controller
public class PublishCenterController {

    @Autowired
    @Resource(name = "PublishService")
    private PublishServiceInterface publishServiceInterface;

    /**
     * 今日抢试发送
     */
    @RequestMapping(value = "/gettodaytry", method = RequestMethod.POST)
    public void getTodayTry() {
        System.out.println("ok");
    }

    /**
     * 通知发送
     * @param notice
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getnotice", method = RequestMethod.POST)
    public boolean getNoticeInfo(@ModelAttribute Notice notice) {
        return publishServiceInterface.SaveNotice(notice);
    }

}
