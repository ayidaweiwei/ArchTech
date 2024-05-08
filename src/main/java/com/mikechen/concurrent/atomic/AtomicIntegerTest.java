package com.mikechen.concurrent.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 	Atomic详解
 *
 * @author mikechen
 *
 */
public class AtomicIntegerTest {

    //private static int num = 0;
    private static AtomicInteger num=new AtomicInteger();

    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            new Thread(){
                @Override
                public void run(){
                    for (int j = 0; j < 100; j++) {
                       // System.out.println(num++);
                        System.out.println(num.getAndIncrement());
                        num.incrementAndGet();
                    }
                }
            }.start();
        }
    }


}
