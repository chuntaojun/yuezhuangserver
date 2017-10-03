package com.yueserver.database.impl;

import com.yueserver.database.dao.PrdVidMapper;
import com.yueserver.enity.PrdVideo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;

@Service("PrdVidSql")
public class PrdVidSql implements PrdVidMapper {

    @Resource
    private PrdVidMapper prdVidMapper;

    @Override
    public boolean saveBatchPrdVid(ArrayList<PrdVideo> prdVideos) {
        return this.prdVidMapper.saveBatchPrdVid(prdVideos);
    }

    @Override
    public boolean deleBatchPrdVid(HashSet<Integer> prdVideos) {
        return this.deleBatchPrdVid(prdVideos);
    }
}
