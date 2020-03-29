package com.youngzy.refactoring.edition2.ch01;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONReader;
import org.junit.Test;

import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class StatementTest {

    @Test
    public void readJSON() throws Exception {
        JSONReader r = new JSONReader(new InputStreamReader(getClass().getResourceAsStream("/plays.json")));

        Map<String, Object> map = new HashMap<String, Object>();
        Object o = r.readObject(map);

//        JSONObject jo = new JSONObject(map.get("othello"));
        Play jsonObject = JSONObject.parseObject(map.get("othello").toString(), Play.class);
//        Object o = r.readObject();
//        Play p = r.readObject(Play.class);

//        Object obj = new JSONParser().parse(new InputStreamReader(getClass().getResourceAsStream("/plays.json")));
//        JSONObject playJSON = (JSONObject) obj;

//        Play play = (Play)playJSON;
//
//        JSONAware s = new JSONAware() {
//            @Override
//            public String toJSONString() {
//                return null;
//            }
//        }
//

        System.out.println(jsonObject.name);

    }
}