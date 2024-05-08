package com.mikechen.java.generic.use;

public class TestGeneric {
    public static void main(String[] args) {

        //TODO 1:泛型类
        GenericClass<String> name = new GenericClass<>("mikechen的互联网架构");
        GenericClass<Integer> age = new GenericClass<>(123456);
        System.out.println("-------------泛型类-------------");
        System.out.println(name.getValue());
        System.out.println(age.getValue());

        GenericClass<Integer> number = new GenericClass<>(123);
        System.out.println(number.getValue());


        //TODO 2:泛型接口
        System.out.println("-------------泛型接口-------------");
        GenericInterface g1 = new StringShowImpl();
        g1.show("hello mikechen");


        //TODO 3：泛型方法
        System.out.println("-------------泛型方法-------------");
        GenericFun gf=new GenericFun();
        gf.genercMethod(123);
        gf.genercMethod("mikechen");


    }
}
