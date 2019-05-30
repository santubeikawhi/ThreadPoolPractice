package com.jl.threadpool.defineThread;

/**
 * @ClassName MyTask
 * @Description TODO
 * @Author Jiangl
 * @Date 2019/4/24 9:38
 * @Version 1.0
 */
public class MyTask implements Runnable {
    private String name;

    public MyTask(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.toString()+"is Running");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "MyTask[name=" + name +"]";
    }
}
