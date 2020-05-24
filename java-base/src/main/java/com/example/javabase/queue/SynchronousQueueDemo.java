package com.example.javabase.queue;

import java.sql.Time;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author sunliang
 * @version 1.0
 * @date 2020/5/24 13:01
 */
public class SynchronousQueueDemo
{
    public static void main(String[] args)
    {
        BlockingQueue<String> blockingQueue = new SynchronousQueue<>();

        new Thread(() -> {
            try
            {
                System.out.println(Thread.currentThread().getName() + "\t put 1");
                blockingQueue.put("1");
                System.out.println(Thread.currentThread().getName() + "\t put 2");
                blockingQueue.put("2");
                System.out.println(Thread.currentThread().getName() + "\t put 3");
                blockingQueue.put("3");
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        },"AAA").start();

        new Thread(() -> {
            try
            {
                TimeUnit.SECONDS.sleep(5);
                System.out.println(Thread.currentThread().getName()+ " \t " + blockingQueue.take());
                TimeUnit.SECONDS.sleep(5);
                System.out.println(Thread.currentThread().getName()+ " \t " + blockingQueue.take());
                TimeUnit.SECONDS.sleep(5);
                System.out.println(Thread.currentThread().getName()+ " \t " + blockingQueue.take());
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        },"BBB").start();
    }
}
