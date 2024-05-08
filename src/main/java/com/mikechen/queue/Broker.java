package com.mikechen.queue;

import java.util.concurrent.ArrayBlockingQueue;

public class Broker {
    // 消息容量
    private final static int MAX_SIZE = 10;

    // 存储消息
    private static ArrayBlockingQueue<String> messageQueue = new ArrayBlockingQueue<String>(MAX_SIZE);

    // 接收消息：生产
    public static void receive(String msg) {
        if (messageQueue.offer(msg)) {
            System.out.println("成功向消息处理中心投递消息：" + msg + "，当前暂存的消息数量是：" + messageQueue.size());
        } else {
            System.out.println("消息处理中心内暂存的消息达到最大负荷，不能继续放入消息！");
        }
        System.out.println("=======================");
    }

    // 转发消息:消费
    public static String consume() {
        String msg = messageQueue.poll();
        if (msg != null) {
            // 消费条件满足情况，从消息容器中取出一条消息
            System.out.println("已经消费消息：" + msg + "，当前暂存的消息数量是：" + messageQueue.size());
        } else {
            System.out.println("消息处理中心内没有消息可供消费！");
        }
        System.out.println("=======================");

        return msg;
    }
}
