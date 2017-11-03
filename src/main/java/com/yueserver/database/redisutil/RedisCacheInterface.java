package com.yueserver.database.redisutil;

import com.yueserver.enity.noenity.ResultBean;

import java.util.List;
import java.util.Map;

public interface RedisCacheInterface {

    ResultBean<Boolean> ListCache(ResultBean<List> resultBean, String key);
    ResultBean<Boolean> NumberCache(ResultBean<Integer> resultBean, String key);
    ResultBean<Boolean> DeleteValueCache(String key);
    List getListCache(String key);

}
