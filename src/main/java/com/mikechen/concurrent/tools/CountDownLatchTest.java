package com.mikechen.concurrent.tools;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch实战案例  老大是主线程 ：开会    子线程：参加开会
 *
 * @author mikechen
 */
public class CountDownLatchTest {

    private static CountDownLatch countDownLatch = new CountDownLatch(5);

    /**
     * 主线程，等待员工到达开会
     */
    static class BossThread extends Thread {

        @Override
        public void run() {
            System.out.println("老大在会议室等待，总共有" + countDownLatch.getCount() + "个人开会...");
            try {
                //Boss等待
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("老大看所有人都已经到齐了，开会吧...");
        }
    }

    /**
     * 主线程2，等待员工到达开会
     */
    static class Boss2Thread extends Thread {

        @Override
        public void run() {
            System.out.println("老大2在会议室等待，总共有" + countDownLatch.getCount() + "个人开会...");
            try {
                //Boss等待
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("老大2看所有人都已经到齐了，开会吧...");
        }
    }


    //员工到达会议室
    static class EmpleoyeeThread extends Thread {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "，到达会议室....");

            //员工到达会议室 count - 1
            countDownLatch.countDown();
        }
    }


    public static void main(String[] args) {
        //主线程启动
        new BossThread().start();
        //主线2程启动
        new Boss2Thread().start();

        for (int i = 0; i < countDownLatch.getCount(); i++) {
            new EmpleoyeeThread().start();
        }
    }


}
