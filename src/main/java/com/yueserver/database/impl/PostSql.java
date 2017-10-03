package com.yueserver.database.impl;

import com.yueserver.database.dao.PostMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

@Service("PostSql")
public class PostSql implements PostMapper {

    @Resource
    private PostMapper postMapper;

    @Override
    public List queryPostInfo() {
        return this.postMapper.queryPostInfo();
    }

    @Override
    public List queryPostInfo2HotRecommend() {
        return this.postMapper.queryPostInfo2HotRecommend();
    }

    @Override
    public boolean deleBatchPost(Set<Integer> postNos) {
        return this.postMapper.deleBatchPost(postNos);
    }

}
