package com.yueserver.database.redisutil.impl;

import com.yueserver.database.redisutil.RedisCacheInterface;
import com.yueserver.enity.nodao.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("RedisCache")
public class RedisCache implements RedisCacheInterface {

    @Autowired
    @Resource(name = "redisTemplate")
    private RedisTemplate redisTemplate;


    @Override
    public void ListCache(ResultBean<List> resultBean, String key) {
        redisTemplate.opsForList().rightPushAll(key, resultBean.getData());
    }

    @Override
    public void MapCache(ResultBean<Map> resultBean, String key) {

    }

    /**
     * 获取redis中缓存的数据 根据特定的 key 信息
     * @param key
     * @return
     */
    @Override
    public List getListCache(String key) {
        return redisTemplate.opsForList().range(key, 0, -1);
    }
}
