package com.yueserver.service.algorithm;

import com.yueserver.database.dao.PostMapper;
import com.yueserver.database.redisutil.RedisCacheInterface;
import com.yueserver.enity.noenity.ResultBean;
import com.yueserver.service.PythonRecommendInterface;
import com.yueserver.database.dao.PrdLikeMapper;
import com.yueserver.database.dao.ProductMapper;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

@Service("Recommend2UserLink")
public class RecommendService implements PythonRecommendInterface {

    @Autowired
    @Resource(name = "RedisCache")
    private RedisCacheInterface redisCacheInterface;

    @Autowired
    @Resource(name = "PrdLikeSql")
    private PrdLikeMapper prdLikeDao;

    @Autowired
    @Resource(name = "ProductSql")
    private ProductMapper productDao;

    @Autowired
    @Resource(name = "PostSql")
    private PostMapper postDao;

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
        if (redisCacheInterface.getListCache("prdLike-" + useraccount).size() == 0)
            redisCacheInterface.ListCache(new ResultBean<>(prdLikeDao.queryPrdLikeData()), "prdLike" + useraccount);
        return new ResultBean<>(redisCacheInterface.getListCache("prdLike-" + useraccount));
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
            redisCacheInterface.ListCache(new ResultBean<>(postDao.queryPostInfo2HotRecommend()), "postHot");
        List<List> hotList = redisCacheInterface.getListCache("postHot");
        return new ResultBean<>(hotList);
    }

    /**
     * 获取帖子数据  获取媒介 redis 缓存服务
     * @return new ResultBean<List<List>>()
     */
    @Override
    public ResultBean<List<List>> getHotPostDataInfo() {
        return new ResultBean<>(postDao.queryPostInfo2HotRecommend());
    }

    /**
     * redis 缓存数据库数据用于用户推荐
     * (数据库的数据还未添加，暂时还没有数据存储到 redis 缓存中)
     * @param resultBean
     */
    @Override
    public ResultBean<Boolean> RedisCacheData(ResultBean<JSONArray> resultBean, String key) {
        if (redisCacheInterface.getListCache(key).size() == 0) {
            List cacheList = productDao.queryRecommendPrd(resultBean.getData());
            if (cacheList.size() != 0)
                redisCacheInterface.ListCache(new ResultBean<>(cacheList), key);
            return new ResultBean<>(true);
        }
        return new ResultBean<>(false);
    }
}