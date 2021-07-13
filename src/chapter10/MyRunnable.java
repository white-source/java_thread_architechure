package chapter10;

public class MyRunnable implements  Runnable {
    @Override
    public void run() {
        System.out.println("this is a part of thread");
    }

    public static void main(String[] args) {
        MyRunnable myRunnable=new MyRunnable();
        Thread thread=new Thread(myRunnable);
        thread.start();

    }
}


