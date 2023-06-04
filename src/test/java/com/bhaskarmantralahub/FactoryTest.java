package com.bhaskarmantralahub;

import lombok.ToString;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class FactoryTest {

    private final String param;

    public FactoryTest(String param) {
        this.param = param;
    }

    @Test(priority = 0)
    public void test() {
        System.out.println("My name is " + this.param);
    }

    @Factory
    @Test(dependsOnMethods = "factoryMethod1")
    public static Object[] factoryMethod() {
        return new FactoryTest[]{new FactoryTest("Hey"), new FactoryTest("Hola")};
    }

    @Factory
    public static Object[] factoryMethod1() {
        return new FactoryTest[]{new FactoryTest("Hello")};
    }

}

