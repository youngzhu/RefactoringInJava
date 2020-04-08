package com.youngzy.refactoring.edition2.ch12.tp10.ex01;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONReader;
import com.youngzy.refactoring.edition2.ch12.tp10.ex01.v03.*;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class BirdFactoryTest {

    private JSONObject birds = new JSONObject();

    @Before
    public void setUp() throws Exception {
        InputStream jsonStream = getClass().getResourceAsStream("/birds.json");
        JSONReader jsonReader = new JSONReader(new InputStreamReader(jsonStream));

        jsonReader.readObject(birds);
    }

    @Test
    public void createEuropeanSwallow() {
        Bird europeanSwallow = BirdFactory.createBird(birds.getJSONObject("EuropeanSwallow"));

        assertEquals("欧洲燕", europeanSwallow.getName());
        assertEquals("黑色 一般", europeanSwallow.getPlumage());
        assertEquals(35, europeanSwallow.getAirSpeedVelocity());
    }

    @Test
    public void createAfricanSwallow() {
        Bird africanSwallow = BirdFactory.createBird(birds.getJSONObject("AfricanSwallow"));

        assertEquals("非洲燕", africanSwallow.getName());
//        assertEquals("黑色 一般", africanSwallow.getPlumage());
        assertEquals(34, africanSwallow.getAirSpeedVelocity());
    }

    @Test
    public void createNorwegianBlueParrot() {
        Bird norwegianBlueParrot = BirdFactory.createBird(birds.getJSONObject("NorwegianBlueParrot"));

        assertEquals("挪威蓝鹦鹉", norwegianBlueParrot.getName());
        assertEquals("五颜六色 漂亮极了", norwegianBlueParrot.getPlumage());
        assertEquals(19, norwegianBlueParrot.getAirSpeedVelocity());
    }
}