package com.youngzy.refactoring.edition2.ch12.tp10.ex01.v02;

import com.alibaba.fastjson.JSONObject;

public class BirdFactory {
    public static Bird createBird(JSONObject rawData) {

        switch (rawData.getString("type")) {
//            case "EuropeanSwallow":
//                return new EuropeanSwallow(rawData);

            case "NorwegianBlueParrot":
                return new NorwegianBlueParrot(rawData);
            default:
                return new Bird(rawData);
        }
    }
}
