package com.mikechen.concurrent.tools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Semaphore 案例：10辆车抢占3个车位
 *
 * @author mikechen
 */
public class SemaphoreTest {

    // 3个车位
    private static Semaphore semaphore = new Semaphore(3);

    public static void main(String[] args) {

        ExecutorService service = Executors.newFixedThreadPool(10);
        ExecutorService service1 = Executors.newCachedThreadPool();
        ExecutorService service2 = Executors.newSingleThreadScheduledExecutor();

        // 10辆车抢占3个车位
        for (int i = 0; i < 10; i++) {
            service.execute(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + " 汽车到了停车场，开始等待===");
                    semaphore.acquire();

                    System.out.println(Thread.currentThread().getName() + " 汽车抢到车位---");
                    Thread.sleep(3000);

                    System.out.println(Thread.currentThread().getName() + "停车3秒后离开");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            });
        }
        service.shutdown();
    }

}
