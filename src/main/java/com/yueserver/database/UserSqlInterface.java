package com.yueserver.database;

import com.yueserver.enity.User;

import java.util.List;

public interface UserSqlInterface {

    List queryUserInfo();

    boolean updateSingleUser(User user);
}
