package com.yueserver.service;

import com.yueserver.enity.nodao.ResultBean;
import net.sf.json.JSONArray;

import java.io.IOException;
import java.util.List;

public interface PythonRecommendInterface {

    ResultBean getUserToRecommend(String useraccount) throws IOException;
    ResultBean<List> getRecommendDataInfo(String useraccount);
    ResultBean<List<List>> getHotPostToRecommend();
    ResultBean<List<List>> getHotPostDataInfo();
    ResultBean<Boolean> RedisCacheData(ResultBean<JSONArray[]> resultBean);

}
