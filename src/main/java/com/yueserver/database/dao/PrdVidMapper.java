package com.yueserver.database.dao;

import com.yueserver.enity.PrdVideo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;

@Repository
public interface PrdVidMapper {

    boolean saveBatchPrdVid(ArrayList<PrdVideo> prdVideos);

    boolean deleBatchPrdVid(HashSet<Integer> prdVideos);

}
