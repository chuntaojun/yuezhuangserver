package com.yueserver.database.impl;

import com.yueserver.database.dao.PrdFavMapper;
import com.yueserver.enity.PrdFav;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service("PrdFavSql")
public class PrdFavSql implements PrdFavMapper {

    @Resource
    private PrdFavMapper prdFavMapper;

    @Override
    public boolean savePrdFav(@Param("PrdFav") PrdFav prdFav) {
        return this.prdFavMapper.savePrdFav(prdFav);
    }

    @Override
    public List queryPrdFavData() {
        return this.prdFavMapper.queryPrdFavData();
    }
}
