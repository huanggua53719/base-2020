package com.example.javabase.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 自旋锁
 * @author sunliang
 * @version 1.0
 * @date 2020/5/23 9:02
 */
public class SpinLockDemo
{
    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void myLock()
    {
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName()+" \t come in mylcok");

        while(!atomicReference.compareAndSet(null,thread))
        {

        }
    }

    public void myUnLock()
    {
        Thread thread = Thread.currentThread();
        atomicReference.compareAndSet(thread,null);
        System.out.println(Thread.currentThread().getName()+" \t myUnlcok");
    }

    public static void main(String[] args)
    {
        SpinLockDemo spinLockDemo = new SpinLockDemo();

        new Thread(() ->{
            spinLockDemo.myLock();
            try
            {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            spinLockDemo.myUnLock();
        },"AA").start();

        try
        {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }


        new Thread(() ->{
            spinLockDemo.myLock();
            spinLockDemo.myUnLock();
        },"BB").start();

    }

}
