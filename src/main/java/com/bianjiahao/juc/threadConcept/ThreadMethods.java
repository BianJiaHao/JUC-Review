package com.bianjiahao.juc.threadConcept;

import java.util.concurrent.TimeUnit;

/**
 * 线程的方法
 * @author BianJiaHao
 */
public class ThreadMethods {
    public static void main(String[] args) {
        // testSleep();
        // testYield();
        testJoin();
    }

    static void testSleep(){
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                System.out.println("A" + i);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    static void testYield(){
        new Thread(()->{
            for (int i = 0; i < 100; i++) {
                System.out.println("A" + i);
                if (i % 10 == 0){
                    Thread.yield();
                }
            }
        }).start();

        new Thread(()->{
            for (int i = 0; i < 100; i++) {
                System.out.println("--------------------" + i);
                if (i % 10 == 0){
                    Thread.yield();
                }
            }
        }).start();
    }

    static void testJoin(){
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 100; i++) {
                System.out.println("A" + i);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(()->{
            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 100; i++) {
                System.out.println("B" + i);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
    }
}
