package com.yueserver.controller;

import com.yueserver.enity.Notice;
import com.yueserver.service.PublishServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Secured("ROLE_ADMIN")
@Controller
@RequestMapping(value = "/admin/push")
public class PublishCenterController {

    @Autowired
    @Resource(name = "PublishService")
    private PublishServiceInterface publishServiceInterface;

    /**
     * 今日抢试发送
     */
    @RequestMapping(value = "/TodayTry", method = RequestMethod.POST)
    public void getTodayTry() {
        System.out.println("ok");
    }

    /**
     * 通知发送
     * @param notice
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/Notice", method = RequestMethod.POST)
    public boolean getNoticeInfo(@ModelAttribute Notice notice) {
        return publishServiceInterface.SaveNotice(notice);
    }

}
