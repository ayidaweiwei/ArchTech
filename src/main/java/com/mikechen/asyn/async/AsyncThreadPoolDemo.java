package com.mikechen.asyn.async;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 异步线程池实现
 * @author mikechen
 */
public class AsyncThreadPoolDemo {

    public static void serviceA() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("--- serviceA---");
    }

    public static void serviceB() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("--- serviceB---");

    }

    public static void serviceC() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("--- serviceC---");

    }

    // 自定义线程池
    private final static int AVALIABLE_PROCESSORS = Runtime.getRuntime().availableProcessors();
    private final static ThreadPoolExecutor POOL_EXECUTOR = new ThreadPoolExecutor(AVALIABLE_PROCESSORS,
            AVALIABLE_PROCESSORS * 2, 1, TimeUnit.MINUTES, new LinkedBlockingQueue<>(5),
            new ThreadPoolExecutor.CallerRunsPolicy());

    public static void main(String[] args) throws InterruptedException {

        long start = System.currentTimeMillis();

        // 1.异步执行服务A
        POOL_EXECUTOR.execute(() -> {
            try {
                serviceA();

            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        //TODO 主线程可以不阻塞的做其他事情

        // 2.执行服务B
         serviceB();

        // 3.执行服务C
        serviceC();


        //4.最后执行打印时间花费
        System.out.println("一共花费："+(System.currentTimeMillis() - start)+"毫秒");

        // 4.挂起当前线程
        //Thread.currentThread().join();

        System.out.println(Thread.currentThread().getName());

    }

}
