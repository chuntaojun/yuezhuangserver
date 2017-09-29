package com.yueserver.controller;

import com.yueserver.enity.nodao.ResultBean;
import com.yueserver.service.PythonRecommendInterface;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.*;

/**
 * 用于推荐算法获取信息进行用户推荐
 */
@Controller
@RequestMapping(value = "/user")
public class PythonRecommendController {

    @Autowired
    @Resource(name = "Recommend2UserLink")
    private PythonRecommendInterface pythonRecommendInterface;

//    /**
//     * 实际项目中采用的接口
//     * @param accessToken
//     * @return
//     */
//    @ResponseBody
//    @RequestMapping(value = "/recommend")
//    public ResultBean<Map<String, List<String>>> getUserInfoToRecommend(String accessToken) {
//        return null;
//    }

    /**
     * 调用此接口返回数据到Python服务器进行算法调度
     * @param useraccount
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/request/recommend/test", method = RequestMethod.POST)
    public ResultBean<List<String>> getUserInfoToRecommend(String useraccount) throws IOException {
        return pythonRecommendInterface.getUserToRecommend(useraccount);
    }

    /**
     * 该接口用于接受Python服务器算法实现后返回的推荐数据，然后通过数据库取出对应商品书然后
     * 返回AppServer进行前端用户界面展示
     * @param json
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/recommend/answer", method = RequestMethod.POST)
    public ResultBean<Boolean> CacheRecommendInfo(@RequestBody String json) {
        JSONObject jsonObject = JSONObject.fromObject(json);
        JSONArray[] jsonData = new JSONArray[]{(JSONArray) jsonObject.get("prdId"), (JSONArray) jsonObject.get("nearUser")};
        return pythonRecommendInterface.RedisCacheData(new ResultBean<>(jsonData));
    }

    /**
     * App端发起 /user/app/recommend/product/info/{useraccount} 的请求
     * 根据用户名返回不同用户算法推荐结果的数据信息
     * @param useraccount
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/app/get/recommend/product/info/{useraccount}", method = RequestMethod.POST)
    public ResultBean<List> getRecommendInfo(@PathVariable String useraccount) {
        return pythonRecommendInterface.getRecommendDataInfo(useraccount);
    }

    /**
     * 进行帖子的热度排序，将数据传输至 Python 服务器进行算法调度
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/request/hot/post", method = RequestMethod.POST)
    public ResultBean<List<List>> getHostPost() {
        return pythonRecommendInterface.getHotPostToRecommend();
    }
}
