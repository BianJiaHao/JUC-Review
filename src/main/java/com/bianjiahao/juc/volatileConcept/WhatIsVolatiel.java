package com.bianjiahao.juc.volatileConcept;

import java.util.concurrent.TimeUnit;

/**
 * volatile and CAS
 * @author BianJiaHao
 */
public class WhatIsVolatiel {
    volatile boolean running = true;

    void m() {
        System.out.println("m start");
        while (running){

        }
        System.out.println("m end");
    }

    public static void main(String[] args) {
        WhatIsVolatiel t = new WhatIsVolatiel();
        new Thread(t::m,"t1").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t.running = false;
    }
}
