package com.yueserver.database;

import java.util.Map;

public interface PrdPicSqlInterface {

    boolean saveBatchPrdPic(Map<String, Object> prdpicMap);

    boolean deleBatchPrdPic(Map<String, Object> prdpicMap);

}
