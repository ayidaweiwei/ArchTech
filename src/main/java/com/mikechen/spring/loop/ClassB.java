package com.mikechen.spring.loop;

public class ClassB {

    private ClassA classA;

    public ClassA getClassA() {
        return classA;
    }

    public void setClassA(ClassA classA) {
        this.classA = classA;
    }

    public void sayHello() {
        System.out.println("hello world");
    }
}
