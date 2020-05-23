package com.example.javabase.thread;

import com.example.javabase.thread.enums.CountryEnum;

import java.util.concurrent.CountDownLatch;

/**
 * @author sunliang
 * @version 1.0
 * @date 2020/5/23 17:15
 */
public class CountDownLatchDemo
{
    public static void main(String[] args) throws Exception
    {
        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 1; i <= 6; i++)
        {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t 国，被灭");
                countDownLatch.countDown();
            }, CountryEnum.forEach_CountryEnum(i).getRetMessage()).start();
        }

        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + " \t **************** 秦帝国，一统华夏");
    }

    private static void closeDoor() throws InterruptedException
    {
        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 1;i <= 6 ; i++)
        {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t 上完自习 离开教室");
                countDownLatch.countDown();
            }, String.valueOf(i)).start();
        }

        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + " \t **************** 班长最后关门走人");
    }
}
