package com.mikechen.proxy;

/**
 * 静态代理
 *
 * @author mikechen
 */
public class SubjectProxy implements Subject {

    Subject subimpl = new RealSubject();

    public void doSomething() {
        //beforeService
        System.out.println("before:doSomething");

        subimpl.doSomething();

        //afterService
        System.out.println("after：doSomething");
    }


}
