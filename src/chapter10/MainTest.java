package chapter10;

public class MainTest {

    public static void main(String[] args){
        TestBean testBean1 = new TestBean();
        TestBean testBean2 = new TestBean();

        new Thread(new Runnable() {
            @Override
            public void run() {
                testBean1.method1("method1");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                testBean2.method2("method2");
            }
        }).start();
    }
}

