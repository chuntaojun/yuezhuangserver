package com.yueserver.database.dao;

import com.yueserver.enity.PrdVideo;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface PrdVidMapper {

    boolean saveBatchPrdVid(int prdNo, List<String> prdVideos);

    boolean deleBatchPrdVid(int prdNo, Set<Integer> prdVideos);

}
