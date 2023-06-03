package com.bhaskarmantralahub;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class ParentTest extends SuperTest {

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Parent Test beforeSuite");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("Parent Test afterSuite");
    }
}
