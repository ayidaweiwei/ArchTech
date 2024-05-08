package com.mikechen.jvm;

/**
 * JVM 内存溢出案例详解
 *
 * @author  mikechen
 *
 */

import java.util.ArrayList;
import java.util.List;

public class MemoryOOM {

    static class Obj{ }

    /** * -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError * */

    public static void main(String[] args) {
        List<Obj> list = new ArrayList<>();
        try {
            while (true){
                list.add(new Obj());
            }
        }catch (Throwable t){
            t.printStackTrace();
            System.out.println("集合大小"+list.size());
        }
    }
}
