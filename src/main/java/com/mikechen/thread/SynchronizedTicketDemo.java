package com.mikechen.thread;

/**
 * 	多线程Synchronized案例
 *
 * @author mikechen
 *
 */
public class SynchronizedTicketDemo implements Runnable {

    //当前可以卖的票数
    private int num=100;


    @Override
    public void run() {

        while(true) {

            synchronized (this) {

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


                if(num>0) {

                    System.out.println(Thread.currentThread().getName()+"----剩余票数----"+num--);
                }
            }

        }

    }

//	@Override
//	public void run() {
//
//		while(true) {
//
//			if(num>0) {
//
//				try {
//					Thread.sleep(10);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//
//				System.out.println(Thread.currentThread().getName()+"----剩余票数----"+num--);
//			}
//
//
//		}
//
//	}
//



    public static void main(String[] args) {
        // TODO Auto-generated method stub

        SynchronizedTicketDemo ticket=new SynchronizedTicketDemo();

        for(int i=1;i<4;i++){

        }

        //创建4个线程卖票
        Thread thread1=new Thread(ticket);
        Thread thread2=new Thread(ticket);
        Thread thread3=new Thread(ticket);
        Thread thread4=new Thread(ticket);


        //启动线程
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();



    }

}
