package interview;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class AtomicTest {
    private static final int threadCount = 60;

    public static void main(String[] args) throws InterruptedException {
//        AtomicInteger integer = new AtomicInteger(10);
//        integer.incrementAndGet();
//        CountDownLatch countDownLatch = new CountDownLatch(10);

        /**
         *     for (int i = 0; i < threadCount; i++) {
         *
         *
         *       });
         *     }
         *     countDownLatch.await();
         *     threadPool.shutdown();
         *     System.out.println("finish");
         */
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 1000,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(100), new ThreadPoolExecutor.AbortPolicy());
        final CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        for (int i = 0; i < threadCount; i++) {
           final int finalI = i;
            executor.execute(() -> {
                try {
                    System.out.println(finalI);
                } finally {
                    System.out.println("countdown");
                    countDownLatch.countDown();
                }
            });
        }

        System.out.println(countDownLatch.getCount());

        countDownLatch.await();
        executor.shutdown();
        System.out.println("finished");
    }
}
