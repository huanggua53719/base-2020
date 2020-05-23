package com.example.javabase.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author sunliang
 * @version 1.0
 * @date 2020/5/23 17:41
 * 跟countDownLatch相反。数据到7后才执行想要执行的方法
 */
public class CyclicBarrierDemo
{
    public static void main(String[] args)
    {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () -> {
            System.out.println("**************召唤神龙");
        });

        for (int i = 0; i < 7; i++)
        {
            final int tempInt = i;
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t 收集到 第： " + tempInt + "龙珠");
                try
                {
                    cyclicBarrier.await();
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                } catch (BrokenBarrierException e)
                {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }
    }
}
