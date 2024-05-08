package com.mikechen.proxy;

/**
 * Real Subject
 *
 * @author mikechen
 */
public class RealSubject implements Subject {

    @Override
    public void doSomething() {
        System.out.println( "call:doSomething()" );
    }
}
