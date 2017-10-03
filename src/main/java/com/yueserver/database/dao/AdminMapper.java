package com.yueserver.database.dao;

import com.yueserver.enity.Administator;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminMapper {

    Administator AdminLogin(String account);

}
