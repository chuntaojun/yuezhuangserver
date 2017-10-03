package com.yueserver.database.impl;

import com.yueserver.enity.Post;
import com.yueserver.database.PostSqlInterface;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("PostSql")
public class PostSql implements PostSqlInterface {

    @Autowired
    @Resource(name = "sqlSessionFactory")
    private SqlSessionFactory sqlSessionFactory;


    @Override
    public List queryPostInfo() {
        return null;
    }

    @Override
    public List queryPostInfo2HotRecommend() {
        return null;
    }

    @Override
    public boolean deleSinglePost(Post post) {
        return false;
    }

    @Override
    public boolean deleBatchPost(Map<String, Object> postMap) {
        return false;
    }
}
