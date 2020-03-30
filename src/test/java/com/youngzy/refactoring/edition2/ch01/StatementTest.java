package com.youngzy.refactoring.edition2.ch01;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONReader;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class StatementTest {

    private Statement stat;

    @Before
    public void setUp() throws Exception {
        stat = new Statement();
    }

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

    }

    @Test
    public void loadPlays() {
        Map<String, Play> playMap = stat.loadPlays(getClass().getResourceAsStream("/plays.json"));

        Play play = playMap.get("as-like");
        Assert.assertEquals("As You Like It", play.getName());
        Assert.assertEquals("comedy", play.getType());
    }

}