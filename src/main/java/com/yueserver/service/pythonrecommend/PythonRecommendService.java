package com.yueserver.service.pythonrecommend;

import com.yueserver.enity.nodao.ResultBean;
import com.yueserver.service.PythonRecommendInterface;
import com.yueserver.sql.PrdFavSqlInterface;

import com.yueserver.sql.ProductSqlInterface;
import net.sf.json.JSONArray;
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

    @Autowired
    @Resource(name = "ProductSql")
    private ProductSqlInterface productSqlInterface;

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

    @Override
    public ResultBean<Boolean> getRecommendDataInfo(ResultBean<JSONArray[]> resultBean) {
        JSONArray prdId = resultBean.getData()[0];
        JSONArray nearUser = resultBean.getData()[1];
        List prdList = productSqlInterface.queryProductInfo(prdId);
        System.out.println(prdList);
        if (prdList != null)
            return new ResultBean<>(true);
        return new ResultBean<>(false);
    }


}
