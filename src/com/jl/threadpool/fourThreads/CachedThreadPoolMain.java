package com.jl.threadpool.fourThreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName CachedThreadPoolMain 缓存线程池
 * @Description TODO
 * @Author Jiangl
 * @Date 2019/4/23 10:39
 * @Version 1.0
 */
public class CachedThreadPoolMain {
    public static void main(String[] args){
        ExecutorService pool = Executors.newCachedThreadPool();
        for(int i=1;i<=10;i++){
            final int task = i;
            pool.submit(new Runnable() {
                @Override
                public void run() {
                    /*try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }*/
                    for(int i=1;i<=10;i++){
                        System.out.println(Thread.currentThread().getName()+"正在执行第"+task+"个任务，第"+i+"次循环");
                    }
                }
            });
        }
        System.out.println("所有线程任务都已被提交到线程池");
        pool.shutdown();
    }
}
