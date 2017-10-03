package com.yueserver.service.pythonrecommend;

import com.yueserver.database.dao.PostMapper;
import com.yueserver.database.redisutil.RedisCacheInterface;
import com.yueserver.enity.nodao.ResultBean;
import com.yueserver.service.PythonRecommendInterface;
import com.yueserver.database.dao.PrdFavMapper;
import com.yueserver.database.dao.ProductMapper;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

@Service("Recommend2UserLink")
public class PythonRecommendService implements PythonRecommendInterface {

    @Autowired
    @Resource(name = "RedisCache")
    private RedisCacheInterface redisCacheInterface;

    @Autowired
    @Resource(name = "PrdFavSql")
    private PrdFavMapper prdFavSqlInterface;

    @Autowired
    @Resource(name = "ProductSql")
    private ProductMapper productSqlInterface;

    @Autowired
    @Resource(name = "PostSql")
    private PostMapper postSqlInterface;

    private String username;

    /**
     * 定时循环任务 将数据存储到 redis 缓存数据库中，并每十二个小时定时更新数据推荐，以保持推荐算法数据的时效性
     * (此处缓存用于 Python 服务器的推荐算法所用)
     * @param useraccount
     * @return
     * @throws IOException
     */
    @Override
    public ResultBean getUserToRecommend(String useraccount) throws IOException {
        username = useraccount;
        if (redisCacheInterface.getListCache("prdFav-" + useraccount).size() == 0)
            redisCacheInterface.ListCache(new ResultBean<>(prdFavSqlInterface.queryPrdFavData()), "prdFav" + useraccount);
        return new ResultBean<>(redisCacheInterface.getListCache("prdFav-" + useraccount));
    }

    /**
     * 获取向用户推荐的数据信息，从 redis 缓存中获取
     * @return
     */
    @Override
    public ResultBean<List> getRecommendDataInfo(String useraccount) {
        return new ResultBean<>(redisCacheInterface.getListCache("recommend-" + useraccount));
    }

    /**
     * 定时循环任务， 将帖子数据存储到 redis 缓存服务器，每隔三个小时定时更新帖子数据，以保持热门帖子推荐数据的时效性
     * (此处缓存用于 Python 服务器的推荐算法所用)
     * @return
     */
    @Override
    public ResultBean<List<List>> getHotPostToRecommend() {
        if (redisCacheInterface.getListCache("postHot").size() == 0)
            redisCacheInterface.ListCache(new ResultBean<>(postSqlInterface.queryPostInfo2HotRecommend()), "postHot");
        List<List> hotList = redisCacheInterface.getListCache("postHot");
        System.out.println(hotList);
        return new ResultBean<>(hotList);
    }

    /**
     * 获取帖子数据  获取媒介 redis 缓存服务
     * 帖子的热度排序实现， 将结果存到redis缓存中
     * @return
     */
    @Override
    public ResultBean<List<List>> getHotPostDataInfo() {
        return null;
    }

    /**
     * redis 缓存数据库数据用于用户推荐
     * (数据库的数据还未添加，暂时还没有数据存储到 redis 缓存中)
     * @param resultBean
     */
    @Override
    public ResultBean<Boolean> RedisCacheData(ResultBean<JSONArray[]> resultBean) {
        JSONArray prdId = resultBean.getData()[0];
        JSONArray nearUser = resultBean.getData()[1];
        if (redisCacheInterface.getListCache("recommend-" + username).size() == 0) {
            List cacheList = productSqlInterface.queryProductInfo(prdId);
            if (cacheList.size() != 0)
                redisCacheInterface.ListCache(new ResultBean<>(cacheList), "recommend-" + username);
            return new ResultBean<>(true);
        }
        if (redisCacheInterface.getListCache("nearUser-" + username).size() == 0) {
            redisCacheInterface.ListCache(new ResultBean<>(), "nearUser-" + username);
            return new ResultBean<>(true);
        }
        return new ResultBean<>(false);
    }



}
