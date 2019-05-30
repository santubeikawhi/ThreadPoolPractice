package com.jl.threadpool.defineThread;

import java.util.concurrent.*;

/**
 * @ClassName DefineThreadMain
 * @Description TODO
 * @Author Jiangl
 * @Date 2019/4/24 10:03
 * @Version 1.0
 */
public class DefineThreadMain {
    public static void main(String[] args){
        ThreadPoolExecutor pool = null;

        ThreadPoolExecutor pool2 = null;
        try {
            int corePoolSize = 2;
            int maxPoolSize = 4;
            long keepAliveTime = 10;
            BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<Runnable>(2);
            TimeUnit timeUnit = TimeUnit.SECONDS;
            ThreadFactory myThreadFactory = new NameThreadFactory();
            RejectedExecutionHandler myIgnorePolicy = new MyIgnorePolicy();
            pool = new ThreadPoolExecutor(corePoolSize,maxPoolSize,keepAliveTime,timeUnit,
                    workQueue,myThreadFactory,myIgnorePolicy);
            pool.prestartAllCoreThreads();//预启动所有核心线程

            pool2 = new ThreadPoolExecutor(corePoolSize,maxPoolSize,keepAliveTime,timeUnit,
                    workQueue,myThreadFactory,myIgnorePolicy);
            pool2.prestartAllCoreThreads();//预启动所有核心线程
            for(int i=0;i<=10;i++){
                MyTask myTask = new MyTask(String.valueOf(i));
                pool.submit(myTask);
            }
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            pool.shutdown();
        }
    }
}
