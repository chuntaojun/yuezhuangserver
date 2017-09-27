package com.yueserver.service;

import com.yueserver.enity.nodao.ResultBean;
import net.sf.json.JSONArray;

import java.io.IOException;
import java.util.List;

public interface PythonRecommendInterface {

    ResultBean getUserToRecommend(String useraccount) throws IOException;
    ResultBean<Boolean> getRecommendDataInfo(ResultBean<JSONArray[]> resultBean);

    void RedisCacheData(List prdList);
}
