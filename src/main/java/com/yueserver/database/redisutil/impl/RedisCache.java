package com.yueserver.database.redisutil.impl;

import com.yueserver.database.redisutil.RedisCacheInterface;
import com.yueserver.enity.noenity.ResultBean;
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
    public ResultBean<Boolean> ListCache(ResultBean<List> resultBean, String key) {
        boolean ans = resultBean.getData().size() == redisTemplate.opsForList().rightPushAll(key, resultBean.getData());
        return new ResultBean<>(ans);
    }

    @Override
    public ResultBean<Boolean> NumberCache(ResultBean<Integer> resultBean, String key) {
        boolean ans = 1 == redisTemplate.opsForValue().append(key, resultBean.getData().toString());
        return new ResultBean<>(ans);
    }

    @Override
    public ResultBean<Boolean> DeleteValueCache(String key) {
        if (redisTemplate.opsForValue().get(key) != null) {
            redisTemplate.delete(key);
            return new ResultBean<>(true);
        }
        return new ResultBean<>(false);
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
