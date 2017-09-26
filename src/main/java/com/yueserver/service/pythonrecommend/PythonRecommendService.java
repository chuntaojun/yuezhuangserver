package com.yueserver.service.pythonrecommend;

import com.yueserver.enity.nodao.ResultBean;
import com.yueserver.service.PythonRecommendInterface;
import com.yueserver.sql.PrdFavSqlInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

@Service("Recommend2UserLink")
public class PythonRecommendService implements PythonRecommendInterface {

    @Autowired
    @Resource(name = "redisTemplate")
    private RedisTemplate redisTemplate;

    @Autowired
    @Resource(name = "PrdFavSql")
    private PrdFavSqlInterface prdFavSqlInterface;

    @Override
    public ResultBean<List<String>> getUserToRecommend(String useraccount) throws IOException {
        return new ResultBean<>(prdFavSqlInterface.queryPrdFavData());
    }

    /**
     * redis 缓存数据库数据用于用户推荐
     */
    @Override
    public void RedisCacheData() {

    }


}
