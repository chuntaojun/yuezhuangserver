package com.yueserver.service;

import com.yueserver.enity.nodao.ResultBean;

import java.util.List;
import java.util.Map;

public interface PythonRecommendInterface {

    ResultBean<Map<String, List<String>>> getUserToRecommend(String useraccount);

}
