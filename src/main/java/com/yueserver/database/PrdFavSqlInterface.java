package com.yueserver.database;

import com.yueserver.enity.PrdFav;

import java.util.List;

public interface PrdFavSqlInterface {

    boolean savePrdFav(PrdFav prdFav);
    List queryPrdFavData();

}
