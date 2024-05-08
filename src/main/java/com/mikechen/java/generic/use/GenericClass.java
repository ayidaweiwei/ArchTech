package com.mikechen.java.generic.use;

/**
 * 泛型类
 *
 * @author mikechen
 */
public class GenericClass<T> {
    private T value;

    public GenericClass(T value) {
        this.value = value;
    }

    public T getValue() {

        return value;
    }

    public void setValue(T value) {

        this.value = value;
    }
}


