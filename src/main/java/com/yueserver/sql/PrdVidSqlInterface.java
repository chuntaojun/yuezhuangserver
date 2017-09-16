package com.yueserver.sql;

import java.util.Map;

public interface PrdVidSqlInterface {

    boolean saveBatchPrdVid(Map<String, Object> prdvidMap);

    boolean deleBatchPrdVid(Map<String, Object> prdvidMap);

}
