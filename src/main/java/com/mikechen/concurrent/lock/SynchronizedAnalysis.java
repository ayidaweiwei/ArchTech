package com.mikechen.concurrent.lock;

public class SynchronizedAnalysis {

    public synchronized  void test1(){

        System.out.println("welcome to youzhixueyuan");
    }

    public  void test2(){
        synchronized (this){
            System.out.println("welcome to youzhixueyuan");
        }
    }

}
