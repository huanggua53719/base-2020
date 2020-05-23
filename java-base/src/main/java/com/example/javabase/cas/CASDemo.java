package com.example.javabase.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author sunliang
 * @version 1.0
 * @date 2020/5/18 21:11
 *
 * CAS 是什么？ ===>compaeAndSet
 *         比较并交换
 */
public class CASDemo
{

    public static void main(String[] args)
    {
        AtomicInteger atomicInteger = new AtomicInteger(5);

        System.out.println(atomicInteger.compareAndSet(5,2019)+"\t current data: " +atomicInteger.get() );

        System.out.println(atomicInteger.compareAndSet(5,1024)+"\t current data: " +atomicInteger.get() );

        atomicInteger.getAndIncrement();
    }



}
