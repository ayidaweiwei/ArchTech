package com.mikechen.spring.loop;


public class ClassA {

    private ClassB classB;

    public ClassB getClassB() {
        return classB;
    }

    public void setClassB(ClassB classB) {
        this.classB = classB;
    }

    public void sayHello() {
        System.out.println("hello world");
    }
}
