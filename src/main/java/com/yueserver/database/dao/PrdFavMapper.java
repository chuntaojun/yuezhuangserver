package com.yueserver.database.dao;

import com.yueserver.enity.PrdFav;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrdFavMapper {

    boolean savePrdFav(@Param("PrdFav") PrdFav prdFav);
    List queryPrdFavData();

}
