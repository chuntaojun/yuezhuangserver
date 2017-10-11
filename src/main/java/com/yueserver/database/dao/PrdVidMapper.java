package com.yueserver.database.dao;

import org.springframework.stereotype.Repository;
import java.util.Set;
import java.util.List;

@Repository
public interface PrdVidMapper {

    boolean saveBatchPrdVid(int prdNo, List<String> prdVideos);

    boolean deleBatchPrdVid(Set<Integer> prdNos);

}
