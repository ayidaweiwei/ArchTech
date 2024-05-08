package com.mikechen.spring.loop;

public class MyAspect {

    public void before() {
        System.out.println("前置增强处理...");
    }

    public void after() {
        System.out.println("后置增强处理...");
    }
}
