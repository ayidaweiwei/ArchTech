package com.mikechen.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriterLockDemo {


    ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

    Lock readLock = reentrantReadWriteLock.readLock();
    Lock writeLock = reentrantReadWriteLock.readLock();

}
