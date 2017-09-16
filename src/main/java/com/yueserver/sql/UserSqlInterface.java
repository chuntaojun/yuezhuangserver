package com.yueserver.sql;

import com.yueserver.bean.User;

import java.util.List;

public interface UserSqlInterface {

    List queryUserInfo();

    boolean updateSingleUser(User user);
}
