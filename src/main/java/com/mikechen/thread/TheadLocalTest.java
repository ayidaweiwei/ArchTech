package com.mikechen.thread;

/**
 * ThreadLocal详解
 *
 * @author mikechen
 */

public class TheadLocalTest {

    static ThreadLocal<String> localName = new ThreadLocal<>();

    static void print(String str) {
        System.out.println(str + " :" + localName.get());
        localName.remove();
    }

    public static void main(String[] args) {
        Thread t1  = new Thread(new Runnable() {
            @Override
            public void run() {
                //设置线程1中本地变量的值
                localName.set("mikechen");
                print("thread1");
                System.out.println("after remove : " + localName.get());
            }
        });

        Thread t2  = new Thread(new Runnable() {
            @Override
            public void run() {
                //设置线程2中本地变量的值
                localName.set("互联网架构");
                print("thread2");
                System.out.println("after remove : " + localName.get());
            }
        });

        t1.start();
        t2.start();
    }

}
