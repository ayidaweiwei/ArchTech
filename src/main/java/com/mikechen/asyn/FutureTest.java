package com.mikechen.asyn;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        System.out.println("start");
        Future<Integer> submit = executorService.submit(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 1;
        });
        Integer value = null;
        try {
            value = submit.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(value);
        System.out.println("end");

    }
}
