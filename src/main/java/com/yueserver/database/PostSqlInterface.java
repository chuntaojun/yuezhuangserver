package com.yueserver.database;

import com.yueserver.enity.Post;

import java.util.List;
import java.util.Map;

public interface PostSqlInterface {

    List queryPostInfo();
    List queryPostInfo2HotRecommend();
    boolean deleSinglePost(Post post);
    boolean deleBatchPost(Map<String, Object> postMap);

}
