package com.jl.threadpool.defineThread;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @ClassName MyIgnorePolicy
 * @Description TODO
 * @Author Jiangl
 * @Date 2019/4/24 9:35
 * @Version 1.0
 */
public class MyIgnorePolicy implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        doLog(r,executor);
    }

    private void doLog(Runnable r, ThreadPoolExecutor executor){
        System.err.println( r.toString() + " rejected");
//        System.out.println("completedTaskCount: " + executor.getCompletedTaskCount());
    }
}
