package com.bhaskarmantralahub;

import org.testng.annotations.Test;

public class DataProviderTest {

    @Test(dataProvider = "test-provider", dataProviderClass = DataProviderBaseTest.class)
    public void test(String wish, String name) {
        System.out.println(wish + " " + name);
    }
}