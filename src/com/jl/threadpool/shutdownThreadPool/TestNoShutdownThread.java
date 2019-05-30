package com.jl.threadpool.shutdownThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName TestNoShutdownThread
 * @Description TODO
 * @Author Jiangl
 * @Date 2019/4/23 10:02
 * @Version 1.0
 */
public class TestNoShutdownThread {
    public static void main(String[] args){
        while(true){
            try {
                ExecutorService service =  Executors.newFixedThreadPool(2);
                service.submit(new Runnable() {
                    public void run() {
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                        }
                    }
                });
            } catch (Exception e) {
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
        }
    }
}
