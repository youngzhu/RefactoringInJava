package com.youngzy.refactoring.edition2.ch06.tp08;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.youngzy.refactoring.edition2.ch06.tp08.v02.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.ListIterator;

import static org.junit.Assert.*;

public class FooTest {
    private static final String DATA = "{\n" +
            "  \"name\": \"王二\",\n" +
            "  \"readings\": [\n" +
            "    {\n" +
            "      \"temp\": 36.0,\n" +
            "      \"time\": \"2020-03-04 09:08\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"temp\": 36.5,\n" +
            "      \"time\": \"2020-03-05 09:18\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"temp\": 38.0,\n" +
            "      \"time\": \"2020-03-06 09:00\"\n" +
            "    }\n" +
            "  ]\n" +
            "}";

    Foo foo;
    ListIterator<Object> temperatureData;

    @Test
    public void readingOutsideRange() {
        NumberRange range = new NumberRange(35, 37.5);

        assertEquals(true, foo.readingOutsideRange(temperatureData, range));
    }

    @Test
    public void readingInsideRange() {
        NumberRange range = new NumberRange(35, 38);

        assertEquals(false, foo.readingOutsideRange(temperatureData, range));
    }

    @Before
    public void setUp() throws Exception {
        foo = new Foo();
        JSONObject obj = (JSONObject) JSONObject.parse(DATA);
        JSONArray array = obj.getJSONArray("readings");

        temperatureData =  array.listIterator();
    }
}