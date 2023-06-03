package com.bhaskarmantralahub;

public class ChildClass extends ParentClass
{

    public ChildClass() {
//        System.out.println("Inside Child Class");
    }

    @Override
    public String whoAreYou() {
        return "Child";
    }
}
