package com.bianjiahao.juc.volatileConcept;

/**
 * 单例模式一
 * @author BianJiaHao
 */
public class Mgr01 {
    private static final Mgr01 INSTANCE = new Mgr01();

    private Mgr01(){}

    public static Mgr01 getInstance(){
        return INSTANCE;
    }

    public void m(){
        System.out.println("m");
    }

    public static void main(String[] args) {
        Mgr01 instance1 = Mgr01.getInstance();
        Mgr01 instance2 = Mgr01.getInstance();
        System.out.println(instance1 == instance2);
    }
}
