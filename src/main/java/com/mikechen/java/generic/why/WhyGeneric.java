package com.mikechen.java.generic.why;

import java.util.ArrayList;

/**
 * 为什么要使用泛型
 *
 * @author mikechen
 */
public class WhyGeneric {

    /**
     * 没有使用泛型
     */
    public static void noGeneric() {
        ArrayList names = new ArrayList();
        names.add("mikechen的互联网架构");
        names.add(123); //编译正常
    }


    /**
     * 使用泛型
     */
    public static void useGeneric() {
        ArrayList<String> names = new ArrayList<>();
        names.add("mikechen的互联网架构");
        //names.add(123); //编译不通过

    }


    /**
     * 避免开箱和装箱
     */
    public  static  void packGeneric(){
        int i=10;
        Object o=i;//装箱
        int j=(int)o; //拆箱

    }


}
