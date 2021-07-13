package chapter10;


import java.util.concurrent.TimeUnit;

public class TestBean {

    private final static Object objectLock = new Object();


    void method1(String threadName) {
        System.out.println("not synchronized method1");
        synchronized (TestBean.class) {
            try {
                System.out.println("method1 start by " + threadName);
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("method end by " + threadName);
        }
    }

    void method2(String threadName) {
        System.out.println("not synchronized method2");
        synchronized (TestBean.class) {
            try {
                System.out.println("method2 start by " + threadName);
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("method end by " + threadName);
        }
    }

}
