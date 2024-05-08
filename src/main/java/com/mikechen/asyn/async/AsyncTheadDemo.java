package com.mikechen.asyn.async;

/**
 * 异步线程实现
 *  @author mikechen
 */
public class AsyncTheadDemo {

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



	public static void main(String[] args) throws InterruptedException {

		long start = System.currentTimeMillis();

		// 1.异步执行服务A
		Thread threadA = new Thread(() -> {
			try {
				serviceA();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}, "threadA");
		threadA.start();
		//TODO 主线程可以不阻塞的做其他事情

		// 2.异步执行服务B
		Thread threadB = new Thread(() -> {
			try {
				serviceB();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}, "threadB");
		threadB.start();

		// 3.执行服务C
		Thread threadC = new Thread(() -> {
			try {
				serviceC();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}, "threadC");
		threadC.start();

		// 4.同步等待线程A,B,C运行结束
		threadA.join();
		threadB.join();
		threadC.join();

		//5.最后执行打印时间花费
		System.out.println("一共花费："+(System.currentTimeMillis() - start)+"毫秒");
	}



}