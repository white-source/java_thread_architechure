package chapter03;

import java.util.concurrent.TimeUnit;

/**
 * 线程中断
 */
public class ThreadInterrupt {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main thread is interrupted?" + Thread.currentThread().isInterrupted());
        Thread.currentThread().interrupt();
        System.out.println("Main thread is interrupted?" + Thread.currentThread().isInterrupted());
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (Exception e) {
            System.out.println("I will be interrtupted still");
        }
    }
}
