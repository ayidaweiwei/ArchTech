package com.mikechen.queue;

/**
 * 生产者客户端测试类：
 */
public class ProducerClient {
    public static void main(String[] args) throws Exception {
        MqClient client = new MqClient();
        client.produce("SEND:Hello World");
    }
}
