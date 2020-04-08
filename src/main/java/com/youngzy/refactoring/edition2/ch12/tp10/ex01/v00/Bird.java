package com.youngzy.refactoring.edition2.ch12.tp10.ex01.v00;

import com.alibaba.fastjson.JSONObject;

public class Bird {
    private String name;
    protected String plumage;
    private int airSpeedVelocity;

    public Bird(JSONObject rawData) {
        this.name = rawData.getString("name");
        this.plumage = rawData.getString("plumage");
    }

    public String getName() {
        return name;
    }

    public String getPlumage() {
        return plumage + " 一般";
    }

    public int getAirSpeedVelocity() {
        return 0;
    }
}
