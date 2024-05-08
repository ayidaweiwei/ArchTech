package com.mikechen.thread;

/**
 * synchronized 实现原理
 *
 * @author mikechen
 *
 */

public class SynchronizedDemo {


    public  synchronized void test1() {

        System.out.println("welcome youzhixueyuan");

    }


    public  void test2() {

        synchronized (this) {

            System.out.println("welcome youzhixueyuan");

        }

    }

    
}
