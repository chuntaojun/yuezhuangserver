package com.yueserver.database.impl;

import com.yueserver.database.dao.PrdVidMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

@Service("PrdVidSql")
public class PrdVidSql implements PrdVidMapper {

    @Resource
    private PrdVidMapper prdVidMapper;

    @Override
    public boolean saveBatchPrdVid(int prdNo, List<String> prdVideos) {
        return this.prdVidMapper.saveBatchPrdVid(prdNo, prdVideos);
    }

    @Override
    public boolean deleBatchPrdVid(Set<Integer> prdNos) {
        return this.deleBatchPrdVid(prdNos);
    }
}
