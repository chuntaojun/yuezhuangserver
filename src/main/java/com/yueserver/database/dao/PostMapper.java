package com.yueserver.database.dao;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface PostMapper {

    List queryPostInfo();
    List queryPostInfo2HotRecommend();
    boolean deleBatchPost(Set<Integer> postNos);

}
