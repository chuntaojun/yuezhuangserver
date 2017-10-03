package com.yueserver.database.dao;

import com.yueserver.enity.PrdPic;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface PrdPicMapper {

    boolean saveBatchPrdPic(int prdNo, List<String> prdPics);
    boolean deleBatchPrdPic(int prdNo, List<String> prdPics);

}
