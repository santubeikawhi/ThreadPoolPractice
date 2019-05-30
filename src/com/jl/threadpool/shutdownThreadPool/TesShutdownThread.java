package com.jl.threadpool.shutdownThreadPool;

import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName TestNoShutdownThread
 * @Description TODO
 * @Author Jiangl
 * @Date 2019/4/23 10:02
 * @Version 1.0
 */
public class TesShutdownThread {
    public static void main(String[] args){
        while(true){
            ExecutorService service =  Executors.newFixedThreadPool(2);
            try {
                service.submit(new Runnable() {
                    public void run() {
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                        }
                    }
                });
            } catch (Exception e) {
            }finally {
                try {
                    service.shutdown();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
        }
    }
}
