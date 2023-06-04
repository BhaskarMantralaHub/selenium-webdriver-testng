package com.bhaskarmantralahub;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterizedTest {



    @Test(priority = 0)
    @Parameters({"name"})
    public void test(@Optional("Hola") String name) {
        System.out.println("My name is " + name);
    }

    @Test(priority = 1)
    @Parameters({"name"})
    public void test1(@Optional("Hello") String name) {
        System.out.println("Inside test1 " + name);
    }

}

