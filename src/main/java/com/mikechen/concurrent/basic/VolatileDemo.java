package com.mikechen.concurrent.basic;


public class VolatileDemo extends  Thread{

    /**
     * 加与不加volatile
     * 不加volatile：main线程中将isRunning设置为flase，VolatileDemo线程中的isRunning不会改变
     *
     * 加上volatile：main线程中将isRunning设置为flase，VolatileDemo线程中的isRunning会随之改变
     */

    private    boolean  isRunning = true;


    private void setRunning(boolean isRunning){
        this.isRunning = isRunning;
    }


    @Override
    public void run(){
        System.out.println("进入run()方法...");

        while(isRunning){

            //如果VolatileDemo线程的isRunning不改为false，线程会永远卡在这里

        }

        System.out.println("线程停止！！！");
    }



    public static void main(String[] args) throws InterruptedException {

        VolatileDemo volatileDemo = new VolatileDemo();

        volatileDemo.start();
        Thread.sleep(1000);
        volatileDemo.setRunning(false);
        System.out.println("isRunning的值已经设置为false...");
    }


}
