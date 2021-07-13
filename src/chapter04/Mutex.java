package chapter04;

import java.util.concurrent.TimeUnit;

public class Mutex {

    private final static Object MUTEXT = new Object();
    public void accessResource(){
        synchronized (MUTEXT){
            try{
                TimeUnit.SECONDS.sleep(3);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args){
        final Mutex mutex= new Mutex();
        for (int i = 0; i < 5; i++) {
            new Thread(mutex::accessResource).start();
        }
    }
}
