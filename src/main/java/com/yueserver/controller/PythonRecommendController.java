package com.yueserver.controller;

import com.yueserver.enity.nodao.ResultBean;
import com.yueserver.service.PythonRecommendInterface;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用于推荐算法获取信息进行用户推荐
 */
@Controller
@RequestMapping(value = "/user/request")
public class PythonRecommendController {

    @Autowired
    @Resource(name = "Recommend2UserLink")
    private PythonRecommendInterface pythonRecommendInterface;

    /**
     * 实际项目中采用的接口
     * @param accessToken
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/recommend")
    public ResultBean<Map<String, List<String>>> getUserInfoToRecommend(String accessToken) {
        return null;
    }

    /**
     * 调用此接口返回数据到Python服务器进行算法调度
     * @param useraccount
     * @param type
     * @return
     */
    @Test
    @ResponseBody
    @RequestMapping(value = "/recommend/test")
    public ResultBean<Map<String, List<String>>> getUserInfoToRecommend(String useraccount, int type) {
        return pythonRecommendInterface.getUserToRecommend(useraccount);
    }

    /**
     * 该接口用于接受Python服务器算法实现后返回的推荐数据，然后通过数据库取出对应商品书然后
     * 返回AppServer进行前端用户界面展示
     */
    @RequestMapping(value = "/recommend/answer")
    public void getRecommendResult(HashMap<String, Integer> recommendPrdInfo) {

    }
}