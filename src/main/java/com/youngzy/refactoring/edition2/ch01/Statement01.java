package com.youngzy.refactoring.edition2.ch01;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONReader;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Statement01 {
    static Invoice invoice;

    public String statement(Invoice invoice, Map<String, Play> plays) {
        double totalAmount = 0;
        int volumeCredits = 0;
        final NumberFormat format = NumberFormat.getCurrencyInstance();

        String result = "Statement for " + invoice.getCustomer() + "\n";

        for (Performance perf : invoice.getPerformances()) {
            final Play play = plays.get(perf.getPlayID());
            double thisAmount = amountFor(perf, play);

            // add volume credits
            volumeCredits += Math.max(perf.getAudience() - 30, 0);
            // add extra credit for every ten comedy attendees
            if ("comedy".equals(play.getType())) {
                volumeCredits += Math.floor(perf.getAudience() / 5);
            }

            // print line for this order
            result += "  " + play.getName() + ": " + format.format(thisAmount / 100)
                        + " (" + perf.getAudience() + " seats)\n";

            totalAmount += thisAmount;

        }

        result += "Amount owed is " + format.format(totalAmount / 100) + "\n";
        result += "You earned " + volumeCredits + " credits\n";

        return result;
    }

    private double amountFor(Performance perf, Play play) {
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
        return thisAmount;
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