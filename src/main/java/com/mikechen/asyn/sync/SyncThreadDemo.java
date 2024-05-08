package com.mikechen.asyn.sync;

/**
 * 同步线程实现
 * @author mikechen
 */
public class SyncThreadDemo {

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


	public static void main(String[] args) {

		long start = System.currentTimeMillis();
		// 1.执行服务A
		serviceA();

		// 2.执行服务B
		serviceB();

		// 3.执行服务C
		serviceC();

		System.out.println("一共花费："+(System.currentTimeMillis() - start)+"毫秒");

	}


}