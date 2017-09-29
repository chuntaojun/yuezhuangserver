package com.yueserver.database;

import java.util.Map;

public interface PrdVidSqlInterface {

    boolean saveBatchPrdVid(Map<String, Object> prdvidMap);

    boolean deleBatchPrdVid(Map<String, Object> prdvidMap);

}
