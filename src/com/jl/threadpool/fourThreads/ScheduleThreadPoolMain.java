package com.jl.threadpool.fourThreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName ScheduleThreadPoolMain
 * @Description TODO
 * @Author Jiangl
 * @Date 2019/4/23 10:48
 * @Version 1.0
 */
public class ScheduleThreadPoolMain {
    public static void main(String[] args){
//        schedule();//定时线程
        scheduleAtFixedRate();//定时频率线程
    }

    private static void schedule(){
        ScheduledExecutorService  pool = Executors.newScheduledThreadPool(3);
        System.out.println("开始提交延迟线程");
        pool.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("爆炸");
            }
        },5, TimeUnit.SECONDS);
        System.out.println("已提交延迟线程");
        pool.shutdown();
    }
    /**
     * 5秒后第一次执行线程，之后每隔2秒执行一次
     * 也就是5秒后打印第一次爆炸，之后每隔2秒打印一次爆炸
     */
    private static void scheduleAtFixedRate(){
        ScheduledExecutorService  pool = Executors.newScheduledThreadPool(3);
        System.out.println("开始提交延迟线程");
        pool.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("爆炸");
            }
        },5,2, TimeUnit.SECONDS);
        System.out.println("已提交延迟线程");
//        pool.shutdown(); 若关闭了线程池，则定时的线程不会执行
    }

}
