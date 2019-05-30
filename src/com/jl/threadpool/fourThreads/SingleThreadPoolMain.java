package com.jl.threadpool.fourThreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName SingleThreadPoolMain
 * @Description TODO
 * @Author Jiangl
 * @Date 2019/4/23 10:56
 * @Version 1.0
 */
public class SingleThreadPoolMain {
    public static void main(String[] args){
        ExecutorService pool = Executors.newSingleThreadExecutor();
        for(int i=1;i<=10;i++){
            final int task = i;
            pool.submit(new Runnable() {
                @Override
                public void run() {
                    for(int i=1;i<=10;i++){
                        System.out.println(Thread.currentThread().getName()+"正在执行第"+task+"个任务，第"+i+"次循环");
                    }
                }
            });
        }
        System.out.println("所有线程都已提交线程池");
        pool.shutdown();
    }
}
