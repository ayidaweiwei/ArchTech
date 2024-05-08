package com.mikechen.jvm;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class VectorMemoryOOM {
    static List list = new ArrayList();

    public static void main(String[] args) {

        Vector vobj = new Vector(10);

        for (int i = 0; i < 100; i++) {

            Object obj = new Object();

            //注意此处Java如何清除内存

            vobj.add(obj);

            obj = null;

            //GC会清除这一块内存吗？

        }

        System.out.print("end");

    }
}
