package com.yueserver.service;

import com.yueserver.enity.nodao.ResultBean;
import net.sf.json.JSONArray;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface PythonRecommendInterface {

    ResultBean<List<String>> getUserToRecommend(String useraccount) throws IOException;
    void RedisCacheData();

    ResultBean<Boolean> getRecommendDataInfo(ResultBean<JSONArray[]> resultBean);

}
