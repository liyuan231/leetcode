package threads;

import java.util.concurrent.TimeUnit;

public class ReentrantLockTest1 {

    synchronized void m1() {
        for (int i = 0; i < 10; i++) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
            m2();
        }
    }

    synchronized void m2() {
        System.out.println("m2");
    }

    public static void main(String[] args) {
        ReentrantLockTest1 reentrantLockTest1 = new ReentrantLockTest1();
        new Thread(reentrantLockTest1::m1).start();
        System.out.println("division!");
        new Thread(reentrantLockTest1::m2).start();
    }
}
