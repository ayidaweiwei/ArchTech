package com.mikechen.concurrent.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 	ReentrantLock实战案例
 *
 * 	铁道部发布了一个售票任务，销售100张票，要求有3个窗口来进行销售，请编写多线程程序来模拟这个效果
 *
 * @author mikechen
 *
 */

public class ReentrantLockTicketDemo {


    // 售票机
    static  class SellTicket {

        private int ticketNum = 100;

        private ReentrantLock lock = new ReentrantLock();

        // 卖票
        public void sell() {

            while (ticketNum > 0) {
                try {
                   
                    lock.lock();

                    if (ticketNum > 0) {
                        try {
                            TimeUnit.MILLISECONDS.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        System.out.println(Thread.currentThread().getName() + " 正在出售第  " + (ticketNum--));
                    }
                } finally {
                    // 释放锁
                    lock.unlock();
                }
            }
        }
    }


    public static void main(String[] args) {

        //创建票资源
        SellTicket sellTicket = new SellTicket();

        // 创建窗口开启3个线程卖票
        new Thread(sellTicket::sell, "窗口 1").start();
        new Thread(sellTicket::sell, "窗口 2").start();
        new Thread(sellTicket::sell, "窗口 3").start();


//        // 创建窗口
//        for(int i = 0;i<4;i++){
//            new Thread(sellTicket::sell, "窗口"+i).start();
//        }


////        // 创建窗口
        for(int i = 0;i<4;i++){
            new Thread(()->{
                sellTicket.sell();
            },String.valueOf(i)+"窗口").start();
        }

//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("测试");
//            }
//        });



    }

}
