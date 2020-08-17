package threads;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

public class AtomicIntegerTest2 {
    static AtomicLong count1 = new AtomicLong(0L);
    static long count2 = 0L;
    static LongAdder count3 = new LongAdder();

    public static void main(String[] args) throws InterruptedException {
        Object mutex = new Object();
        Thread[] threads = new Thread[1000];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int k = 0; k < 100000; k++) {
                    synchronized (mutex) {
                        count2++;
//                    count3.increment();
//                    count1.incrementAndGet();
                    }
                }
            });
        }
//        LongAdder
        long start = System.currentTimeMillis();
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        long end = System.currentTimeMillis();
        System.out.println("花费时间为：" + ((end - start)));
        System.out.println("AtomicLong->count1:" + count1);
        System.out.println("Long->count2:" + count2);
        System.out.println("LongAdder->count2:" + count3);
    }
}
