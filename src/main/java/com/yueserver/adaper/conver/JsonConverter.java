package com.yueserver.adaper.conver;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.List;
import java.util.Map;

/**
 * Created by liaochuntao on 17-7-11.
 */
public class JsonConverter {

    public JsonConverter(){}

    public String setMessage(List list){
        JSONArray jsonarray = new JSONArray().fromObject(list);
        return jsonarray.toString();
    }

    public String setMessage(Map map){
        JSONObject jsonobject = new JSONObject();
        jsonobject.putAll(map);
        return jsonobject.toString();
    }

}
