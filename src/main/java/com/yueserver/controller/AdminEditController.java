package com.yueserver.controller;

import com.yueserver.enity.Brand;
import com.yueserver.enity.Merchant;
import com.yueserver.enity.Product;
import com.yueserver.enity.User;

import com.yueserver.enity.noenity.EventInfo;
import com.yueserver.enity.noenity.ResultBean;
import com.yueserver.service.EditInterface;
import com.yueserver.service.EmailInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by liaochuntao on 17-7-18.
 * 管理员进行增改相关信息的controller
 */
@Controller
@RequestMapping(value = "/admin/edit")
public class AdminEditController {

    @Autowired
    @Resource(name = "AdminEditData")
    private EditInterface editInterface;

    @Autowired
    @Resource(name = "Emailservice")
    private EmailInterface emailInterface;

    /**
     * 更改商品违规信息
     * @param ID
     * @param product
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/Product", method = {RequestMethod.POST})
    public HashMap<String, Boolean> EditForProduct(int ID, @RequestBody Product product) {
        System.out.println(ID + "," + product);
        product.setPrdno(ID);
        HashMap<String, Boolean> responesHashmap = new HashMap<>();
        if (editInterface.updateProInfo(new ResultBean<>(product)).getBoolean("result"))
            responesHashmap.put("judge", true);
        else
            responesHashmap.put("judge", false);
        return responesHashmap;
    }

    /**
     * 更改用户账户状态
     * @param ID
     * @param user
     * @return responesHashmap
     */
    @ResponseBody
    @RequestMapping(value = "/User", method = RequestMethod.POST)
    public HashMap<String, Boolean> EditForUser(int ID, @RequestBody User user) {
        System.out.println(user);
        user.setUserno(ID);
        HashMap<String, Boolean> responesHashmap = new HashMap<>();
        if (editInterface.updateUserInfo(new ResultBean<>(user)).getBoolean("result"))
            responesHashmap.put("judge", true);
        else
            responesHashmap.put("judge", false);
        return responesHashmap;
    }

    /**
     * 商家授权以及商家信息管理操作
     * @param ID int
     * @param merchant Merchant
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/Merchant", method = {RequestMethod.POST})
    public HashMap<String, Boolean> EditForSelller(int ID, @RequestBody Merchant merchant) {
        merchant.setMctno(ID);
        HashMap<String, Boolean> responesHashmap = new HashMap<>();
        if (editInterface.updateMerchantAuthorize(new ResultBean<>(merchant)).getBoolean("result")) {
            if (merchant.getMctstate() == 1)
                emailInterface.SendMerchantCanLogin("1069284099@qq.com");
            System.out.println(new Date());
            responesHashmap.put("judge", true);
        }
        else
            responesHashmap.put("judge", false);
        return responesHashmap;
    }

    /**
     * 品牌信息管理操作
     * @param ID
     * @param brand
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/Brand", method = {RequestMethod.POST})
    public HashMap<String, Boolean> EditForBrand(int ID, @RequestBody Brand brand) {
        brand.setBrdno(ID);
        HashMap<String, Boolean> responesHashmap = new HashMap<>();
        if (editInterface.updateBrandInfo(new ResultBean<>(brand)).getBoolean("result"))
            responesHashmap.put("judge", true);
        else
            responesHashmap.put("judge", false);
        return responesHashmap;
    }

    /**
     *
     * @param eventInfo
     */
    @ResponseBody
    @RequestMapping(value = "/EventInfo", method = RequestMethod.POST)
    public void EditForEventInfo(@RequestBody EventInfo eventInfo) {}
}
