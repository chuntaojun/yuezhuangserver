package com.yueserver.sql;

import java.util.Map;

public interface PrdPicSqlInterface {

    boolean saveBatchPrdPic(Map<String, Object> prdpicMap);

    boolean deleBatchPrdPic(Map<String, Object> prdpicMap);

}
