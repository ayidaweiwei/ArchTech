package com.mikechen.jvm;
/**
 * JVM 栈溢出案例详解
 *
 * @author  mikechen
 *
 */

public class StackOverflowError {
    static class StackOFE{
        int i;
        public void recursive(){
            i++;
            recursive();
        }
    }

    /** * vm args -Xss128k * @param args */
    public static void main(String[] args) {
        StackOFE stackOFE = new StackOFE();
        stackOFE.recursive();
    }
}
