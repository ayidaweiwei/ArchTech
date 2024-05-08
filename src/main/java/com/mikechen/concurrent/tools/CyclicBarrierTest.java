package com.mikechen.concurrent.tools;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 *CyclicBarrier的实战案例  旅游团集体出行
 *
 * @author mikechen
 */

public class CyclicBarrierTest {

        //当THREAD_COUNT 逐个减到0的时候，就开是执行runnable
        private static final int THREAD_COUNT = 5;

        private final static CyclicBarrier CYSLIC_BARRIER = new CyclicBarrier(
                THREAD_COUNT, new Runnable() {

            @Override
            public void run() {
                System.out.println("我是导游，集合完毕，准备开始旅游下一个景点。");
            }
        });


        public static void main (String[]args){


            for (int i = 0; i < THREAD_COUNT; i++) {

                new Thread(String.valueOf(i)) {
                    public void run() {
                        try {
                            System.out.println("我是旅游团成员" + this.getName() + "，我已经到达旅游景点。");
                            CYSLIC_BARRIER.await();
                            //等待被唤醒
                            System.out.println("我是旅游团成员" + this.getName() + "，我们开始旅游：锦里。");


                            CYSLIC_BARRIER.await();
                            //等待被唤醒
                            System.out.println("我是旅游团成员" + this.getName() + "，我们开始旅游：黄龙溪。");


                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } catch (BrokenBarrierException e) {
                            e.printStackTrace();
                        }

                    };
                }.start();
            }
        }

}
