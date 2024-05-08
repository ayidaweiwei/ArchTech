package com.mikechen.java.basics.oop.inherit;

public class InheritTest {

    public static void main(String args[]) {
        Student stu = new Student(); // 实例化的是子类
        stu.setName("mikechen"); // Person类定义
        stu.setAge(30); // Person类定义
        System.out.println("姓名：" + stu.getName() + "，年龄：" + stu.getAge());
    }

}
