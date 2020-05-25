package com.example.javabase.threadpool;

import java.util.concurrent.*;

/**
 * @author sunliang
 * @version 1.0
 * @date 2020/5/24 21:56
 * 第4种获得、使用java多线程的方法，线程池
 */
public class MyThreadPoolDemo
{
    public static void main(String[] args)
    {
        ExecutorService threadPool = new ThreadPoolExecutor(2, 5, 1L,
                TimeUnit.SECONDS,new LinkedBlockingDeque<>(3), Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy());

        try
        {
            for (int i = 0; i < 10; i++)
            {
                threadPool.execute(() ->
                {
                    System.out.println(Thread.currentThread().getName() + "\t 办理业务");
                });

                //                try
                //                {
                //                    TimeUnit.MILLISECONDS.sleep(200);
                //                } catch (Exception e)
                //                {
                //                    e.printStackTrace();
                //                }
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        } finally
        {
            threadPool.shutdown();
        }
    }

    private static void threadPoolInit()
    {
        //        Executor ExecutorS
        //        ExecutorService threadPool = Executors.newFixedThreadPool(5);//一池5个处理线程
        //        ExecutorService threadPool = Executors.newSingleThreadExecutor();//一池1个处理线程
        ExecutorService threadPool = Executors.newCachedThreadPool();//一池N个处理线程

        //模拟10个用户来办理业务，每个用户就是一个来自外部的请求线程

        try
        {
            for (int i = 0; i < 10; i++)
            {
                threadPool.execute(() ->
                {
                    System.out.println(Thread.currentThread().getName() + "\t 办理业务");
                });

//                try
//                {
//                    TimeUnit.MILLISECONDS.sleep(200);
//                } catch (Exception e)
//                {
//                    e.printStackTrace();
//                }
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        } finally
        {
            threadPool.shutdown();
        }
    }
}
