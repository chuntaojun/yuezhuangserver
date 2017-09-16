package com.yueserver.controller;

import com.yueserver.service.DeleteInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * Created by liaochuntao on 17-7-18.
 * 管理员与商家删除相关数据的controller
 */
@Controller
public class DeleteController {

    @Autowired
    @Resource(name = "DeleteData")
    private DeleteInterface deleteservice;

    /**
     * 商家、管理员删除商品信息
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/deleteProduct", method = RequestMethod.POST)
    public HashMap DeleteProduct(int[] no){
        if (deleteservice.DelePrdInfo(no)){
            HashMap hashMap = new HashMap();
            hashMap.put("data", new HashMap().put("stats", 200));
            return hashMap;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("data", new HashMap<>().put("stats", 500));
        return hashMap;
    }

    /**
     * 管理员删除帖子信息
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/admindeletePost", method = RequestMethod.POST)
    public HashMap DeletePost(int[] no){
        if (deleteservice.DelePostInfo(no)){
            HashMap hashMap = new HashMap();
            hashMap.put("data", new HashMap().put("stats", 200));
            return hashMap;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("data", new HashMap<>().put("stats", 500));
        return hashMap;
    }

    /**
     * 管理员删除品牌信息
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/admindeleteBrand", method = RequestMethod.POST)
    public HashMap DeleteBrand(int[] no){
        if (deleteservice.DeleBrandInfo(no)){
            HashMap hashMap = new HashMap();
            hashMap.put("data", new HashMap().put("stats", 200));
            return hashMap;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("data", new HashMap<>().put("stats", 500));
        return hashMap;
    }

    @ResponseBody
    @RequestMapping(value = "/admindeleteUser", method = RequestMethod.POST)
    public HashMap DeleteUser(int[] no){
        return null;
    }

}
