package com.mikechen.concurrent.queue;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 	ConcurrentLinkedQueue
 *
 * 	铁道部发布了一个售票任务，销售100张票，要求有3个窗口来进行销售，请编写多线程程序来模拟这个效果
 *
 * @author mikechen
 *
 */
public class ConcurrentLinkedQueueTest {

       static Queue<String> tickets=new ConcurrentLinkedQueue<String>();

       static{
           for(int i=0;i<100;i++){
               tickets.add("票编号："+i);
           }
       }

    public static void main(String[] args) {

        for(int i = 0;i<3;i++){
            new Thread(()->{
                while (true){
                    String s=tickets.poll();
                    if(s==null) break;
                    else System.out.println("销售了--"+s);
                }
            }).start();
        }

    }

}
