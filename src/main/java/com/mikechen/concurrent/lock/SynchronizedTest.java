package com.mikechen.concurrent.lock;

/**
 * synchronized
 *
 * @author  mikechen
 */
public class SynchronizedTest {
    /**
     * 用在普通方法
     */
    private synchronized void synchronizedMethod() {
        //do something
    }


    /**
     * 用在静态方法
     */
    private synchronized static void synchronizedStaticMethod() {
        //do something
    }


    /**
     * 用在类
     */
    private void synchronizedClass() {

        synchronized (SynchronizedDemo.class) {
            //do something
        }
    }
}
