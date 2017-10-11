package com.yueserver.database.dao;

import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Set;

@Repository
public interface PrdPicMapper {

    boolean saveBatchPrdPic(int prdNo, List<String> prdPics);
    boolean deleBatchPrdPic(Set<Integer> prdNos);

}
