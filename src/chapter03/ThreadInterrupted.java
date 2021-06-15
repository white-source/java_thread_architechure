package chapter03;

import java.util.concurrent.TimeUnit;

/**
 * interrupted()是一个静态方法，用于判断当前线程是否被中断，但是和成员方法isInterrupted()还是有很大区别，
 * 调用该方法会直接擦除线程的interrupt标识，需要注意的是，如果当前线程被打断了，第一次调用interrupted会返回true,
 * 并且立即擦除线程的interrupt标识，第二次包括以后的调用永远返回false,除非在此期间线程再一次被打断
 */
public class ThreadInterrupted {
    public static void main(String[] args) throws InterruptedException {
        /**
         * ...
         * false
         * false
         * false
         * true
         * false
         * false
         * false
         * ...
         */
        //结果是很多false中间有一个true，也就是2毫秒后的interrupt()出现一次，后面的又一直返回false
        Thread thread = new Thread(() -> {
            while (true) {
                System.out.println(Thread.interrupted());
            }
        });
        thread.setDaemon(true);
        thread.start();

        TimeUnit.MILLISECONDS.sleep(2);
        thread.interrupt();
        thread.interrupt();


    }
}
