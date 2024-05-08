package com.mikechen.java.generic;

import com.mikechen.java.generic.use.GenericClass;
import com.mikechen.java.generic.use.GenericInterface;
import com.mikechen.java.generic.use.NumberShowImpl;
import com.mikechen.java.generic.use.StringShowImpl;

import java.util.ArrayList;
import java.util.List;

public class TestGenericClass {

    public static void main(String[] args) {

        //TODO:为什么需要泛型
        List<String> arrayList = new ArrayList<>();
        arrayList.add("mikechen的互联网架构");
        //arrayList.add(7); //..(参数不匹配：int 无法转换为String)


        //TODO:泛型类型擦除
        List<String> stringArrayList = new ArrayList<String>();
        List<Integer> integerArrayList = new ArrayList<Integer>();

        Class classStringArrayList = stringArrayList.getClass();
        Class classIntegerArrayList = integerArrayList.getClass();

        if(classStringArrayList.equals(classIntegerArrayList)){
            System.out.println("泛型测试,类型相同");
        }



        //TODO:泛型的使用

        //1：泛型类
        GenericClass<String> name = new GenericClass<>("mikechen的互联网架构");
        System.out.println(name.getValue());

        GenericClass<Integer> number = new GenericClass<>(123);
        System.out.println(number.getValue());


        //2:泛型接口
        GenericInterface g1 = new NumberShowImpl();
        GenericInterface g2 = new StringShowImpl();


        //TODO:泛型的实现原理

        List<String> l1 = new ArrayList<String>();
        List<Integer> l2 = new ArrayList<Integer>();

        System.out.println(l1.getClass() == l2.getClass());




    }
}
