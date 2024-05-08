package com.mikechen.asyn.async;

import java.util.concurrent.*;

/**
 * 异步 Future编程
 * @author mikechen
 */
public class AsyncCompletableFutureDemo {

    public static String serviceA() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("--- serviceA---");

        return "ServiceA Result";
    }

    public static String serviceB() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("--- serviceB---");

        return "ServiceB Result";

    }

    public static String serviceC() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("--- serviceC---");
        return "ServiceC Result";

    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        long start = System.currentTimeMillis();

        // 1.执行服务A
        CompletableFuture<String> futureTaskA = CompletableFuture.supplyAsync(()->{
            String result = null;
            try {
                result =serviceA();

            } catch (Exception e) {
                e.printStackTrace();
            }
            return result;
        });

        // 如果执行成功
        futureTaskA.thenAccept((result) -> {
            System.out.println("taskAResult: " + result);
        });
        // 如果执行异常
        futureTaskA.exceptionally((e) -> {
            e.printStackTrace();
            return null;
        });

        //2.执行服务B
        String taskBResult= serviceB();

        //3.执行服务C
        String taskCResult=serviceC();

        //5.同步等待线程A运行结束
        //String taskAResult = futureTaskA.get();

        //5.打印三个任务执行结果
        //System.out.println("最终结果为："+taskAResult + "+ " + taskBResult+" +"+taskCResult);

        //6.最后执行打印时间花费
        System.out.println("一共花费："+(System.currentTimeMillis() - start)+"毫秒");
    }

}
