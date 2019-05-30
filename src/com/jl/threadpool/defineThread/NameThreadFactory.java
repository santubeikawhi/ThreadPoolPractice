package com.jl.threadpool.defineThread;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName NameThreadFactory
 * @Description TODO
 * @Author Jiangl
 * @Date 2019/4/24 9:31
 * @Version 1.0
 */
public class NameThreadFactory implements ThreadFactory {

    private final AtomicInteger mThreadNum = new AtomicInteger(1);

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r,"my-thread-"+mThreadNum.getAndIncrement());
        System.out.println(t.getName()+" has been created");
        return t;
    }
}
