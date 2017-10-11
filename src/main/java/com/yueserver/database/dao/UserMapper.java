package com.yueserver.database.dao;

import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public interface UserMapper {

    List queryUserInfo();

    boolean updateUserStatus(int status, int usrNo);
}
