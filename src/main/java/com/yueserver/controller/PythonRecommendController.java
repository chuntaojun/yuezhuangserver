package com.yueserver.controller;

import com.yueserver.enity.noenity.ResultBean;
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
     * 该接口用于接受Python服务器算法实现后返回的推荐数据存储到redis缓存中
     * @param json
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/receive/recommend/answer", method = RequestMethod.POST)
    public ResultBean<Boolean> CacheRecommendInfo(@RequestBody String json) {
        JSONObject jsonObject = JSONObject.fromObject(json);
        JSONArray[] jsonData = new JSONArray[]{(JSONArray) jsonObject.get("prdId"), (JSONArray) jsonObject.get("nearUser")};
        return pythonRecommendInterface.RedisCacheData(new ResultBean<>(jsonData));
    }

    /**
     * 该接口用于接受Python服务器帖子热度计算算法返回的数据结果存储至redis缓存中
     * @param json
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/receive/recommend/HotPost", method = RequestMethod.POST)
    public ResultBean<Boolean> CacheHotPostInfo(@RequestBody String json) {
        JSONObject jsonObject = JSONObject.fromObject(json);
        JSONArray[] jsonData = new JSONArray[]{(JSONArray) jsonObject.get("hotPost")};
        return pythonRecommendInterface.RedisCacheData(new ResultBean<>(jsonData));
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
