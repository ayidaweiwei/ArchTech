package com.mikechen.java.generic.use;

public class NumberShowImpl implements GenericInterface<Integer> {
    @Override
    public void show(Integer value) {
        System.out.println(value);
    }
}
