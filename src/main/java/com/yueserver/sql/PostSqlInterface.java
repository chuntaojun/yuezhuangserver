package com.yueserver.sql;

import com.yueserver.enity.Post;

import java.util.List;
import java.util.Map;

public interface PostSqlInterface {

    List queryPostInfo();

    boolean deleSinglePost(Post post);
    boolean deleBatchPost(Map<String, Object> postMap);

}
