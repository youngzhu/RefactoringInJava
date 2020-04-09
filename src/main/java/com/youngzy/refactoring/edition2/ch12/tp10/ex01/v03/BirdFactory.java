package com.youngzy.refactoring.edition2.ch12.tp10.ex01.v03;

import com.alibaba.fastjson.JSONObject;

public class BirdFactory {
    public static Bird createBird(JSONObject rawData) {

        return new Bird(rawData);
    }
}
