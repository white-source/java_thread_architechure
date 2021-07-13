package chapter10;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class MyCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        return 666;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCallable myCallable=new MyCallable();
        FutureTask<Integer> ft=new FutureTask<>(myCallable);
        Thread thread=new Thread(ft);
        thread.start();
        System.out.println(ft.get());

    }
}
