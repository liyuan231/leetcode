package JAVA;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(5);
        for (int i = 0; i <= 5; i++) {
            semaphore.acquire();
            System.out.println("进入睡眠->" + i);
            Thread.sleep(2000);
            System.out.println("liyuan!" + i);
        }


        semaphore.release();
    }
}
