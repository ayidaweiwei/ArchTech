package com.mikechen.concurrent.container;

import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

/**
 *  ConcurrentHashMap的实现原理
 *   @author mikechen
 *
 */
public class ConcurrentHashMapTest {

    public static void main(String[] args) {

        //初始化ConcurrentHashMap
        ConcurrentHashMap<String,String> map = new ConcurrentHashMap();
        Hashtable<String,String> table=new Hashtable<>();
        table.put("id","1");
        table.get("id");


        //新增个人信息
        map.put("id","1");
        map.put("name","andy");
        map.put("sex","男");

        //获取姓名
        String name = map.get("name");
        //Assert.assertEquals(name,"andy");

        //计算大小
        int size = map.size();
        // Assert.assertEquals(size,3);

    }


}

