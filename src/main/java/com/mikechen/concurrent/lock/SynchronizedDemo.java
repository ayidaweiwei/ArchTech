package com.mikechen.concurrent.lock;

/**
 * synchronized的同步源码详解
 *
 * @author  mikechen
 */

public class SynchronizedDemo {

    /**
     * 用在普通方法
     */
    private synchronized void synchronizedMethod() {

        System.out.println("--synchronizedMethod start--");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("--synchronizedMethod end--");
    }


    /**
     * 用在静态方法
     */
    private synchronized static void synchronizedStaticMethod() {
        System.out.println("synchronizedStaticMethod start");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("synchronizedStaticMethod end");
    }


    /**
     * 用在类
     */
    private void synchronizedClass() {

        synchronized (SynchronizedDemo.class) {
            System.out.println("synchronizedClass start");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("synchronizedClass end");
        }
    }

    /**
     * 用在类
     */
    private void synchronizedGetClass() {
        synchronized (this.getClass()) {
            System.out.println("synchronizedGetClass start");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("synchronizedGetClass end");
        }
    }


    /**
     * 用在this
     */
    private void synchronizedThis() {
        synchronized (this) {
            System.out.println("synchronizedThis start");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("synchronizedThis end");
        }
    }


    Object lock=new Object();

    /**
     * 用在对象
     */
    private void synchronizedInstance() {
        synchronized (lock) {
            System.out.println("synchronizedInstance start");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("synchronizedInstance end");
        }
    }


    public static void main(String[] args) {
        final SynchronizedDemo synTest = new SynchronizedDemo();

        new Thread(synTest::synchronizedMethod).start();

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                synTest.synchronizedMethod();
//            }
//        }).start();

    }



}
