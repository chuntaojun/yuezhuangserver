package com.yueserver.database.impl;

import com.yueserver.database.dao.PrdLikeMapper;
import com.yueserver.enity.PrdLike;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("PrdLikeSql")
public class PrdLikeSql implements PrdLikeMapper {

    @Resource
    private PrdLikeMapper prdLikeMapper;

    @Override
    public boolean savePrdLike(PrdLike prdLike) {
        return this.prdLikeMapper.savePrdLike(prdLike);
    }

    @Override
    public List queryPrdLikeData() {
        return this.prdLikeMapper.queryPrdLikeData();
    }
}
