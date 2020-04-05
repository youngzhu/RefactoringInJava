package com.youngzy.refactoring.edition2.ch01.v07;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONReader;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class JSONUtil {

    public static List<Invoice> loadInvoices(InputStream jsonStream) {
        JSONReader jsonReader = new JSONReader(new InputStreamReader(jsonStream));

        return JSON.parseArray(jsonReader.readString(), Invoice.class);
    }

    public static Map<String, Play> loadPlays(InputStream jsonStream) {
        Map<String, Play> ret = new HashMap<>();

        JSONReader jsonReader = new JSONReader(new InputStreamReader(jsonStream));

        /*
        可以直接read后强制转换成Map
        也可以将Map作为参数，read后数据填充到Map里
         */
//      Map<String, Object> map = (Map<String, Object>) jsonReader.readObject();
        Map<String, JSONObject> map = new HashMap<>();
        jsonReader.readObject(map);

        String key;
        Play play;

        for (Map.Entry<String, JSONObject> entry : map.entrySet()) {
            key = entry.getKey();
            play = JSONObject.parseObject(entry.getValue().toJSONString(), Play.class);

            ret.put(key, play);
        }

        return ret;
    }
}
