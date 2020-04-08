package com.youngzy.refactoring.edition2.ch12.tp10.ex01.v01;

import com.alibaba.fastjson.JSONObject;

public class Bird {
    private String name;
    protected String plumage;
    private int airSpeedVelocity;

    private EuropeanSwallowDelegate delegate;

    public Bird(JSONObject rawData) {
        this.name = rawData.getString("name");
        this.plumage = rawData.getString("plumage");

        delegate = selectDelegate(rawData);
    }

    private EuropeanSwallowDelegate selectDelegate(JSONObject rawData) {
        switch (rawData.getString("type")) {
            case "EuropeanSwallow":
                return new EuropeanSwallowDelegate();
            default:
                return null;
        }
    }

    public String getName() {
        return name;
    }

    public String getPlumage() {
        return plumage + " 一般";
    }

    public int getAirSpeedVelocity() {
        return this.delegate == null ? 0 : delegate.getAirSpeedVelocity();
    }
}
