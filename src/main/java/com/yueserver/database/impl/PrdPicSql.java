package com.yueserver.database.impl;

import com.yueserver.database.dao.PrdPicMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("PrdPicSql")
public class PrdPicSql implements PrdPicMapper {

    @Resource
    private PrdPicMapper prdPicMapper;


    @Override
    public boolean saveBatchPrdPic(int prdNo, List<String> prdPics) {
        return this.prdPicMapper.saveBatchPrdPic(prdNo, prdPics);
    }

    @Override
    public boolean deleBatchPrdPic(int prdNo, List<String> prdPics) {
        return this.prdPicMapper.deleBatchPrdPic(prdNo, prdPics);
    }
}
