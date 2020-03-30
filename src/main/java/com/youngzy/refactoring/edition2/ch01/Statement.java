package com.youngzy.refactoring.edition2.ch01;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONReader;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Statement {
    static Invoice invoice;

    public void statement() {
        double totalAmount = 0;
        int volumeCredits = 0;
        String result = "Statement for " + invoice.customer;

        for (Performance perf : invoice.performances) {
//            final Play play = plays[perf.playID];

        }
    }

    public Map<String, Play> loadPlays(InputStream jsonStream) {
        Map<String, Play> ret = new HashMap<>();

        JSONReader jsonReader = new JSONReader(new InputStreamReader(jsonStream));

        /*
        可以直接read后强制转换成Map
        也可以将Map作为参数，read后数据填充到Map里
         */
//      Map<String, Object> map = (Map<String, Object>) jsonReader.readObject();
        Map<String, JSONObject> map = new HashMap<String, JSONObject>();
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

    private static class Performance {
    }


    private class Invoice {
        String customer;
        Performance[] performances;
    }
}

class Play {

    private String name;
    private String type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
