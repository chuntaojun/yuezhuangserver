package com.yueserver.database.impl;

import com.yueserver.database.dao.PrdPicMapper;
import com.yueserver.enity.PrdPic;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("PrdPicSql")
public class PrdPicSql implements PrdPicMapper {

    @Resource
    private PrdPicMapper prdPicMapper;


    @Override
    public boolean saveBatchPrdPic(List<PrdPic> prdPics) {
        return this.prdPicMapper.saveBatchPrdPic(prdPics);
    }

    @Override
    public boolean deleBatchPrdPic(List<Integer> prdPics) {
        return this.prdPicMapper.deleBatchPrdPic(prdPics);
    }
}
