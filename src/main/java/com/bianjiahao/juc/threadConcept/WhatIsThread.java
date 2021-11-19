package com.bianjiahao.juc.threadConcept;

import ch.qos.logback.core.util.TimeUtil;

import java.util.concurrent.TimeUnit;

/**
 * 什么是线程
 * @author BianJiaHao
 */
public class WhatIsThread {

    private static class T1 extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    TimeUnit.MICROSECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("T1");
            }
        }
    }

    public static void main(String[] args) {
        T1 t1 = new T1();
        t1.start();
        for (int i = 0; i < 10; i++) {
            try {
                TimeUnit.MICROSECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Main");
        }
    }
}
