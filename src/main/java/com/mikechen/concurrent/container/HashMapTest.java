package com.mikechen.concurrent.container;

import java.util.HashMap;
import java.util.Map;

/**
 * hashmap 1.8 实现原理
 *
 * @author mikechen
 *
 */

public class HashMapTest {

    public static void main(String[] args) {

        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "mikechen");
        System.out.println(map.get("name")); ;

    }
}


