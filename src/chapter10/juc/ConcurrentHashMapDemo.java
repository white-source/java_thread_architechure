package chapter10.juc;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {
public static void main(String[] args) {
    ConcurrentHashMap map=new ConcurrentHashMap();
    map.put("a", "aa");
}
}
