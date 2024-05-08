package com.mikechen.concurrent.basic;

public class Singleton {

    // 使用private将构造方法私有化，以防外界通过该构造方法创建多个实例
    private Singleton(){
        System.out.println(Thread.currentThread().getName() +" 私有构造调用了");
    }

    // 由于不能使用构造方法创建实例，所以需要在类的内部创建该类的唯一实例
    // 使用static修饰Singleton, 在外界可以通过类名调用该实例   类名.成员名

    private static Singleton instance;

    public     static Singleton getInstance(){
        //加锁前后都做一次判断

        //第一次检测
        if (instance==null){
            //同步
            synchronized (Singleton.class){

                if (instance == null){
                    //多线程环境下可能会出现问题的地方
                    instance = new Singleton();
                }
            }
        }


     return instance;

    }

}