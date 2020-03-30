package com.youngzy.refactoring.edition2.ch01;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONReader;
import com.alibaba.fastjson.parser.Feature;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Statement {
    static Invoice invoice;

    public String statement(Invoice invoice, Map<String, Play> plays) {
        double totalAmount = 0;
        int volumeCredits = 0;
        String result = "Statement for " + invoice.getCustomer() + "\n";

        for (Performance perf : invoice.getPerformances()) {
            final Play play = plays.get(perf.getPlayID());
            double thisAmount = 0;

            switch (play.getType()) {
                case "tragedy":
                    thisAmount = 40000;
                    if (perf.getAudience() > 30) {
                        thisAmount += 1000 * (perf.getAudience() - 30);
                    }
                    break;
                case "comedy":
                    thisAmount = 30000;
                    if (perf.getAudience() > 20) {
                        thisAmount += 10000 + 500 * (perf.getAudience() - 20);
                    }
                    thisAmount += 300 * perf.getAudience();
                    break;
                default:
                    throw new Error("unknown type:" + play.getType());
            }

            // add volume credits
            volumeCredits += Math.max(perf.getAudience() - 30, 0);
            // add extra credit for every ten comedy attendees
            if ("comedy".equals(play.getType())) {
                volumeCredits += Math.floor(perf.getAudience() / 5);
            }

            // print line for this order
            result += play.getName() + ": " + thisAmount / 100
                        + " (" + perf.getAudience() + " seats)\n";

            totalAmount += thisAmount;

        }

        result += "Amount owed is " + totalAmount / 100 + "\n";
        result += "You earned " + volumeCredits + " credits\n";

        return result;
    }

    public List<Invoice> loadInvoices(InputStream jsonStream) {
        JSONReader jsonReader = new JSONReader(new InputStreamReader(jsonStream));

        return JSON.parseArray(jsonReader.readString(), Invoice.class);
    }

    public Map<String, Play> loadPlays(InputStream jsonStream) {
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

class Performance {
    private String playID;
    private int audience;

    public String getPlayID() {
        return playID;
    }

    public void setPlayID(String playID) {
        this.playID = playID;
    }

    public int getAudience() {
        return audience;
    }

    public void setAudience(int audience) {
        this.audience = audience;
    }

}

class Invoice {
    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public Performance[] getPerformances() {
        return performances;
    }

    public void setPerformances(Performance[] performances) {
        this.performances = performances;
    }

    private String customer;
    private Performance[] performances;
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
