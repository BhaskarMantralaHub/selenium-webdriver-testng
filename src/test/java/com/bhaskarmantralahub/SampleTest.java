package com.bhaskarmantralahub;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SampleTest {

    @BeforeMethod(groups = "test2")
    public void setup() {
        System.out.println("Inside setup");
    }


    @Test
    public void test1() {
        System.out.println("Inside test1");
    }

    @Test(groups = "test2")
    public void test2() {
        System.out.println("Inside test2");
    }
}
