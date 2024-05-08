package com.mikechen.java.generic.use;

public class StringShowImpl implements GenericInterface<String> {
    @Override
    public void show(String value) {
        System.out.println(value);
    }
}
