package com.yueserver.controller;

import javax.servlet.http.HttpSession;

import com.yueserver.service.ShowInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

import static com.yueserver.controller.LoginController.getPrincipal;

/**
 * Created by liaochuntao on 17-7-11.
 */

@Controller
@RequestMapping(value = {"/admin/query", "/user/query"})
public class ShowDataController {

    @Autowired
    private ShowInterface showInterface;

    /**
     * web端呈现商品信息
     * @param refresh
     * @throws IOException
     */
    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @ResponseBody
    @RequestMapping(value = "/Product", method = {RequestMethod.POST, RequestMethod.GET}, produces = "application/json;charset=utf-8")
    public String ReprotProductInfo(boolean refresh) throws IOException {
        return String.valueOf(showInterface.QueryProdInfo(getPrincipal()).getData().get("prdList"));
    }

    /**
     * web端呈现品牌信息
     * @param refresh
     * @throws IOException
     */
    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @ResponseBody
    @RequestMapping(value = "/Brand", method = {RequestMethod.POST, RequestMethod.GET}, produces = "application/json;charset=utf-8")
    public String ReportBrandInfo(boolean refresh) throws IOException {
        return String.valueOf(showInterface.QueryBrandInfo(getPrincipal()).getData().get("brdList"));
    }

    /**
     * web端呈现商家信息
     * @param refresh
     * @throws IOException
     */
    @Secured("ROLE_ADMIN")
    @ResponseBody
    @RequestMapping(value = "/Merchant", method = {RequestMethod.POST, RequestMethod.GET}, produces = "application/json;charset=utf-8")
    public String ReportSellerInfo(boolean refresh) throws IOException {
        return String.valueOf(showInterface.QuerySellerInfo().getData().get("mctList"));
    }

    /**
     * web端呈现用户信息
     * @param refresh
     * @throws IOException
     */
    @Secured("ROLE_ADMIN")
    @ResponseBody
    @RequestMapping(value = "/User", method = {RequestMethod.POST, RequestMethod.GET}, produces = "application/json;charset=utf-8")
    public String ReportUserInfo(boolean refresh) throws IOException {
        return String.valueOf(showInterface.QueryUserInfo().getData().get("usrList"));
    }

    /**
     * web端呈现帖子信息
     * @param refresh
     * @throws IOException
     */
    @Secured("ROLE_ADMIN")
    @ResponseBody
    @RequestMapping(value = "/Post", method = {RequestMethod.POST, RequestMethod.GET}, produces = "application/json;charset=utf-8")
    public String ReportPostInfo(boolean refresh) throws IOException {
        return String.valueOf(showInterface.QueryPostInfo().getData().get("postList"));
    }

}
