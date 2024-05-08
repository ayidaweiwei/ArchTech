package com.mikechen.asyn.async;

import java.util.concurrent.*;

/**
 * 异步 Future编程
 * @author mikechen
 */
public class AsyncFutureDemo {

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

        ExecutorService executorService = Executors.newCachedThreadPool();
        long start = System.currentTimeMillis();

        //1.异步执行服务A
        Future<String> futureTaskA = executorService.submit(() -> {
            String result = null;
            try {
                result =serviceA();

            } catch (Exception e) {
                e.printStackTrace();
            }
            return result;
        });
        //TODO 在输出futureTaskA下面异步结果时,主线程可以不阻塞的做其他事情

        //2.执行服务B
        String taskBResult= serviceB();

        //3.执行服务C
        String taskCResult=serviceC();

        //4.同步等待线程A运行结束
        String taskAResult = futureTaskA.get(); //主线程获取异步结果

        //打印三个任务执行结果
        System.out.println("最终结果为："+taskAResult + "+ " + taskBResult+" +"+taskCResult);

        //最后执行打印时间花费
        System.out.println("一共花费："+(System.currentTimeMillis() - start)+"毫秒");
    }

}
