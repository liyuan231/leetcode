package JVM;

import java.util.ArrayList;
import java.util.List;

public class STWTest {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Thread t1 = new Thread(() -> {
            while (true) {
                System.out.println(System.currentTimeMillis() - startTime);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        List<Integer> list = new ArrayList<>();
        Thread t2 = new Thread(() -> {
            while (true) {
                for (int i = 0; i < 10000; i++) {
                    list.add(i);
                }
                if (list.size() >= 10000000) {
//                    System.out.println("clear!");
                    list.clear();
                    System.gc();
                }
            }
        });
        t1.start();
        t2.start();
    }
}
