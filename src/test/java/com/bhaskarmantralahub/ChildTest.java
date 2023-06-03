package com.bhaskarmantralahub;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class ChildTest extends ParentTest {
    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        System.out.println("Child Test beforeSuite");
    }

    @Test(groups = "sanity")
    public void test() {
        System.out.println("Inside test");
    }

    @Test(groups = "smoke")
    public void test1() {
        System.out.println("Inside test1");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("Child Test afterSuite");
    }
}
