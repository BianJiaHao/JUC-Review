package com.bianjiahao.juc.threadConcept;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * 如何去创建线程
 * @author BianJiaHao
 */
public class HowToCreateThread {

    /**
     * 第一种方式：继承Thread类
     */
    private static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("Hello Word");
        }
    }

    /**
     * 第二种方式：实现Runnable接口
     */
    private static class MyRun implements Runnable {
        @Override
        public void run() {
            System.out.println("Hello Run");
        }
    }

    /**
     * 第三种方式：实现Callable接口
     */
    private static class MyCall implements Callable<String> {
        @Override
        public String call() throws Exception {
            System.out.println("Hello MyCall");
            return "success";
        }
    }

    /**
     * 启动线程的方式
     */
    public static void main(String[] args) {
        new MyThread().start();

        new Thread(new MyRun()).start();

        new Thread(()->{
            System.out.println("Hello");
        }).start();

        new Thread(new FutureTask<String>(new MyCall())).start();

        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(()->{
            System.out.println("Hello ThreadPool");
        });
        service.shutdown();
    }
}
