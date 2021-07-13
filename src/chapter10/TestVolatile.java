package chapter10;

public class TestVolatile {


    static class MyTask extends Thread {
        private volatile boolean closed = false;

        @Override
        public void run() {
            test();
        }

        private void test() {
            int a = 0;//语句1
            int b = 1;//语句2
            a = 10; //语句3
            b = 20; //语句4
            System.out.println("a:"+a +" b:"+ b);

            if (b == 20) {
                System.out.println("a此时已经是10了");
            }
            System.out.println("a:"+a);
        }


    }

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            new MyTask().start();
        }
    }
}
