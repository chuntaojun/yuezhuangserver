package com.yueserver.controller;

import com.yueserver.enity.Notice;
import com.yueserver.enity.nodao.MerchantTicket;
import com.yueserver.enity.nodao.ResultBean;
import com.yueserver.service.PublishServiceInterface;
import com.yueserver.service.TicketInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Secured("ROLE_ADMIN")
@Controller
@RequestMapping(value = {"/admin/push", "/yue/user/push"})
public class PublishCenterController {

    @Autowired
    @Resource(name = "PublishService")
    private PublishServiceInterface publishServiceInterface;

    @Autowired
    @Resource(name = "TicketService")
    private TicketInterface ticketInterface;

    /**
     * 今日抢试发送
     */
    @Secured("ROLE_ADMIN")
    @ResponseBody
    @RequestMapping(value = "/TodayTry", method = RequestMethod.POST)
    public ResultBean<Boolean> getTodayTry() {
        return new ResultBean<>(false);
    }

    /**
     * 通知发送
     * @param notice
     * @return
     */
    @Secured("ROLE_ADMIN")
    @ResponseBody
    @RequestMapping(value = "/Notice", method = RequestMethod.POST)
    public ResultBean<Boolean> getNoticeInfo(@ModelAttribute Notice notice) {
        return publishServiceInterface.SaveNotice(notice);
    }

    /**
     * 商家发布券
     * @return
     */
    @Secured("ROLE_USER")
    @ResponseBody
    @RequestMapping(value = "/Ticket", method = RequestMethod.POST)
    public ResultBean<Boolean> getMerchantTicket(@ModelAttribute MerchantTicket merchantTicket) {
        return ticketInterface.addTicket(merchantTicket);
    }

}
