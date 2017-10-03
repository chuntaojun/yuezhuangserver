package com.yueserver.database.dao;

import com.yueserver.enity.Notice;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticeMapper {

    boolean SaveNotice(Notice notice);

}
