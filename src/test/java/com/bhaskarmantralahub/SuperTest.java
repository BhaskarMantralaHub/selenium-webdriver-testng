package com.bhaskarmantralahub;

import com.beust.jcommander.Parameter;
import org.testng.annotations.*;

public class SuperTest {

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Super Test beforeSuite");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Super BeforeMethod");
    }

    @Test(groups = "sanity")
    @Parameters({"customer_name"})
    public void test(@Optional("Optional Name") String customerName) {
        System.out.println("Inside super test");
        System.out.println("Env is " + System.getProperty("env"));
        System.out.println(customerName);
    }

    @Test(groups = "sanity")
    public void test1() {
        System.out.println("Inside super test1");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("Super Test afterSuite");
    }
}
