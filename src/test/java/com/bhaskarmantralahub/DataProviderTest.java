package com.bhaskarmantralahub;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DataProviderTest {

    @BeforeMethod
    public void beforeMethod(ITestResult testResult) {
        System.out.println("Inside Before Method of " + testResult.getMethod().getMethodName());
    }

    @Test(dataProvider = "test-provider", dataProviderClass = DataProviderClass.class)
    public void test(String wish, String name) {
        System.out.println(wish + " " + name);
    }

    @Test(dataProvider = "test-provider-yaml", dataProviderClass = DataProviderClass.class)
    public void testDataProviderFromYamlFile(String name, String profession) {
        System.out.println(name + " " + profession);

    }
}
