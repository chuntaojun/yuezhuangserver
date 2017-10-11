package com.yueserver.database.dao;

import com.yueserver.enity.PrdLike;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrdLikeMapper {

    boolean savePrdLike(PrdLike prdLike);
    List queryPrdLikeData();

}
