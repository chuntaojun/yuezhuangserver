package com.yueserver.controller;

import com.yueserver.bean.Brand;
import com.yueserver.bean.Merchant;
import com.yueserver.bean.Product;
import com.yueserver.bean.User;

import com.yueserver.bean.nodao.EventInfo;
import com.yueserver.service.EditInterface;
import com.yueserver.service.EmailInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by liaochuntao on 17-7-18.
 * 管理员进行增改相关信息的controller
 */
@Controller
public class AdminEditController {

    @Autowired
    @Resource(name = "AdminEditData")
    private EditInterface editInterface;

    @Autowired
    @Resource(name = "emailservice")
    private EmailInterface emailInterface;

    /**
     * 更改商品违规信息
     * @param ID
     * @param product
     * @return
     */
    @RequestMapping(value = "/editforProduct", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public HashMap<String, Boolean> EditForProduct(int ID, @RequestBody Product product) {
        System.out.println(ID + "," + product);
        product.setPrdno(ID);
        HashMap<String, Boolean> responesHashmap = new HashMap<>();
        if (editInterface.updateProInfo(product).getBoolean("result"))
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
    @RequestMapping(value = "/editforUser", method = RequestMethod.POST)
    @ResponseBody
    public HashMap<String, Boolean> EditForUser(int ID, @RequestBody User user) {
        System.out.println(user);
        user.setUserno(ID);
        HashMap<String, Boolean> responesHashmap = new HashMap<>();
        if (editInterface.updateUserInfo(user).getBoolean("result"))
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
    @RequestMapping(value = "/editforMerchant", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public HashMap<String, Boolean> EditForSelller(int ID, @RequestBody Merchant merchant) {
        merchant.setMctno(ID);
        HashMap<String, Boolean> responesHashmap = new HashMap<>();
        if (editInterface.updateMerchantAuthorize(merchant).getBoolean("result")) {
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
    @RequestMapping(value = "/editforBrand", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public HashMap<String, Boolean> EditForBrand(int ID, @RequestBody Brand brand) {
        brand.setBrdno(ID);
        HashMap<String, Boolean> responesHashmap = new HashMap<>();
        if (editInterface.updateBrandInfo(brand).getBoolean("result"))
            responesHashmap.put("judge", true);
        else
            responesHashmap.put("judge", false);
        return responesHashmap;
    }

    /**
     *
     * @param eventInfo
     */
    @RequestMapping(value = "/editforEventinfo", method = RequestMethod.POST)
    public void EditForEventInfo(@RequestBody EventInfo eventInfo) {}
}
