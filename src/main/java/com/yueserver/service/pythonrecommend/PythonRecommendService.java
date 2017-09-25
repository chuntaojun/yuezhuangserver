package com.yueserver.service.pythonrecommend;

import com.yueserver.enity.nodao.ResultBean;
import com.yueserver.service.PythonRecommendInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("Recommend2UserLink")
public class PythonRecommendService implements PythonRecommendInterface {

    @Autowired
    @Resource(name = "redisTemplate")
    private RedisTemplate redisTemplate;

    @Override
    public ResultBean<Map<String, List<String>>> getUserToRecommend(String useraccount) {
        return null;
    }
}
