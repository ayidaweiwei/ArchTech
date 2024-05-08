package com.mikechen.concurrent.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 	ArrayBlockingQueue 生产者与消费者
 *
 * @author mikechen
 *
 */

public class ArrayBlockingQueueTest {

    //默认非公平阻塞队列
    private static BlockingQueue<Fruit> queue = new ArrayBlockingQueue<Fruit>(2);

    //公平阻塞队列
    //ArrayBlockingQueue queue1 = new ArrayBlockingQueue(2,true);


    class  Fruit{
        private  String name;

        public  Fruit( ){

        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    class Producer implements Runnable {

        @Override
        public void run() {
            Fruit fruit = new Fruit();
            fruit.setName("apple");
            try {
                queue.put(fruit);
                System.out.println(Thread.currentThread().getName() + "provider : " + fruit.getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    class Consumer implements Runnable {

        @Override
        public void run() {
            try {
                Fruit food = queue.take();
                System.out.println(Thread.currentThread().getName() + "consumer : " + food.getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        for (int i = 0 ; i < 2 ; i++) {
            new Thread(new ArrayBlockingQueueTest().new Producer()).start();
        }
        for (int i = 0 ; i < 2 ; i++) {
            new Thread(new ArrayBlockingQueueTest().new Consumer()).start();
        }
    }


}
