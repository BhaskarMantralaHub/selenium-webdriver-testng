package com.bhaskarmantralahub;

import org.testng.annotations.*;

public class ChildTest {
    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        System.out.println("Child Test beforeSuite");
    }

    @Test(groups = "sanity")
    public void test() {
        System.out.println("Inside test");
        assert 10>20;
    }

    @Test(groups = "smoke", enabled = false)
    public void test1() {
        System.out.println("Inside test1");
    }

    @AfterTest()
    public void afterMethod() {
        System.out.println("Child Test afterMethod");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("Child Test afterSuite");
    }
}
