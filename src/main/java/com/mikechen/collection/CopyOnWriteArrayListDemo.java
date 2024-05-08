package com.mikechen.collection;

import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListDemo {

    private static CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<String>();

    public static void main(String[] args) {
        list.add("mike");
    }


}
