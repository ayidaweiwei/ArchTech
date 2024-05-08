package com.mikechen.concurrent.queue;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * 	LinkedBlockingQueue
 *
 * @author mikechen
 *
 */

public class LinkedBlockingQueueTest {

    public static void main(String[] args) throws InterruptedException {

        LinkedBlockingQueue<String> queue = new LinkedBlockingQueue(5);

        //入列
        queue.add("a");  //队列满后抛异常
        queue.put("b");//首选，队列满后阻塞
        queue.offer("c"); //入列失败返回false

        System.out.println(queue);

        queue.put("a");
        queue.put("b");
        queue.put("c");
        queue.put("d");
        queue.put("e");

        //出队
        queue.remove("a"); //删除指定元素
        queue.poll();  //出列，如果队列为空返回null
        queue.take();  //首选，队列为空，阻塞等待

        System.out.println(queue);
    }

}

