package com.mikechen.concurrent.basic;

public class VolatileTest extends Thread {

    private  boolean flag = false;

    private void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        while (!flag){
            System.out.println(1);
        }
        System.out.println("线程停止");
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileTest test = new VolatileTest();
        test.start();

        Thread.sleep(1000);
        test.setFlag(true);

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                test.setFlag(true);
//            }
//        }).start();

    }
}
