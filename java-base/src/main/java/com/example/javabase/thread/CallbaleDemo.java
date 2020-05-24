package com.example.javabase.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

class MyThread2 implements Callable<Integer>
{

    @Override
    public Integer call() throws Exception
    {
        System.out.println("****************** come in Callable");
         try
                 {
                     TimeUnit.SECONDS.sleep(2);
                 } catch (Exception e)
                 {
                     e.printStackTrace();
                 }
        return 1024;
    }
}

/**
 * @author sunliang
 * @version 1.0
 * @date 2020/5/24 21:12
 *
 */
public class CallbaleDemo
{
    public static void main(String[] args) throws Exception
    {

        //两个线程，一个是main线程，一个是FutureTask
//         public FutureTask(Callable<V> callable)
/*        FutureTask<Integer> futureTask = new FutureTask<>(new MyThread2());

        Thread t1 = new Thread(futureTask, "AAA");
        Thread t2 = new Thread(futureTask, "BB");
        t1.start();
        t2.start();*/

        FutureTask<Integer> futureTask = new FutureTask<>(new MyThread2());
        FutureTask<Integer> futureTask2 = new FutureTask<>(new MyThread2());

        Thread t1 = new Thread(futureTask, "AAA");
        Thread t2 = new Thread(futureTask2, "BB");
        t1.start();
        t2.start();
        //判断是否完成
//        while (!futureTask.isDone())
//        {
//
//        }

        Integer integer = futureTask.get();
        //futureTask.get()建议放在最后 要求获取Callbale线程计算结果，如果没有计算完成就要去强求，会导致堵塞，直到计算完成
        System.out.println("************* result: " + integer);

    }
}
