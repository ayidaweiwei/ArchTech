package com.mikechen.java.reflection;

public class Person {

    private String name;
    private String sex;

    public Person(){

    }

    public Person(String name,String sex){
        this.name=name;
        this.sex=sex;
    }

    public void run(){
        System.out.println(" keep running");
    }

    public void work(){

        System.out.println(" keep work");
    }

}
