package com.mikechen.concurrent.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteCache {

    //充当cache
    static Map<String, Object> map = new HashMap<String, Object>();

    //实例化读写锁对象
    static ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

    //实例化读锁
    static Lock r = reentrantReadWriteLock.readLock();

    //实例化写锁
    static Lock w = reentrantReadWriteLock.writeLock();


    //获取缓存中值
    public static final Object get(String key) {
        r.lock();
        try {
            return map.get(key);
        } finally {
            r.unlock();
        }
    }

    //写缓存中值，并返回对应value
    public static final Object set(String key, Object obj) {
        w.lock();
        try {
            return map.put(key, obj);
        } finally {
            w.unlock();
        }
    }

    //清空所有内容
    public static final void clear() {
        w.lock();
        try {
            map.clear();
        } finally {
            w.unlock();
        }
    }
}
