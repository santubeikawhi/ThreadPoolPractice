package com.jl.threadpool.fourThreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName FixedThreadPoolMain 固定线程池
 * @Description TODO
 * @Author Jiangl
 * @Date 2019/4/23 10:27
 * @Version 1.0
 */
public class FixedThreadPoolMain {
    public static void main(String[] args){
        ExecutorService pool = Executors.newFixedThreadPool(3);
        for(int i=1;i<=10;i++){
            final int task = i;
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    for(int i=1;i<=10;i++){
                        System.out.println(Thread.currentThread().getName()+"正在进行第"+task+"个任务，"+"第"+i+"次循环");
                    }
                }
            });
        }
        System.out.println("所有线程都被提交");
        pool.shutdown();
    }
}
