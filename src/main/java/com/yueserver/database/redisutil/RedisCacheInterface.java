package com.yueserver.database.redisutil;

import com.yueserver.enity.nodao.ResultBean;

import java.util.List;
import java.util.Map;

public interface RedisCacheInterface {

    void ListCache(ResultBean<List> resultBean, String key);
    void MapCache(ResultBean<Map> resultBean, String key);

    List getListCache(String key);

}
