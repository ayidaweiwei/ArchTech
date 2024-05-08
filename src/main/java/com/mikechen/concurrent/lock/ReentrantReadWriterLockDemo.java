package com.mikechen.concurrent.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriterLockDemo {

    private final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    private final Lock readLock = readWriteLock.readLock();
    private final Lock writeLock = readWriteLock.writeLock();

    public String read() {
        readLock.lock();
        try {
            //执行的代码快
            return "xxx";
        } finally {
            readLock.unlock();
        }
    }

    

    public void write() {
        writeLock.lock();
        try {
            //执行写操作代码快
            System.out.println("执行写操作代码快");
        } finally {
            writeLock.unlock();
        }
    }




}
