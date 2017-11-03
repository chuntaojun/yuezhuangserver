package com.yueserver.controller.app;

import com.yueserver.enity.noenity.ResultBean;
import com.yueserver.service.PythonRecommendInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping(value = "/mobile/app")
public class AppGetResourcesController {

    @Autowired
    @Resource(name = "Recommend2UserLink")
    private PythonRecommendInterface pythonRecommendInterface;

    /**
     * App端发起 /user/app/recommend/product/info/{useraccount} 的请求
     * 根据用户名返回不同用户算法推荐结果的数据信息
     * @param useraccount
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/get/recommend/product/info/{useraccount}", method = RequestMethod.POST)
    public ResultBean<List> getRecommendInfo(@PathVariable String useraccount) {
        return pythonRecommendInterface.getRecommendDataInfo(useraccount);
    }

    /**
     * App端发起 /user/app/get/hotpost 的请求
     * 服务器返回帖子数据
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/get/hotpost", method = RequestMethod.POST)
    public ResultBean<List<List>> getHotPostInfo() {
        return pythonRecommendInterface.getHotPostToRecommend();
    }

    /**
     * App端发起获取某件商品数据的请求
     * @param accessToken
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/get/resource/product?id={prdId}", method = RequestMethod.POST)
    public ResultBean<List<List>> getProductInfo(String accessToken, @PathVariable int prdId) {
        return null;
    }

    /**
     * App端发起获取某品牌数据的请求
     * @param accessToken
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/get/resources/brand?id={brdId}", method = RequestMethod.POST)
    public ResultBean<List<List>> getBrandInfo(String accessToken) {
        return null;
    }

    /**
     * App端发起获取某商家信息的请求，请求参数为merchantId
     * @param merchantId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/get/resources/merchant/info？id={merchantId}", method = RequestMethod.POST)
    public ResultBean<List<List>> getMerchantInfo(@PathVariable String merchantId) {
        return null;
    }

}
