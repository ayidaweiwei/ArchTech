package com.mikechen.proxy.wine;

public class MaoTai implements Wine {
    @Override
    public void sellWine() {
        System.out.println("销售茅台酒");
    }
}
