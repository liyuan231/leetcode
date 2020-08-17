package threads;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest2 {
    Lock lock = new ReentrantLock();

    void m1() {
        boolean locked = lock.tryLock();
        System.out.println("locked:" + locked);
        System.out.println("method m1 is invoked!");
        try {
            for (int i = 0; i < 10; i++) {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("lock is unlocked!->"+locked);
            lock.unlock();
        }
    }

    void m2() {
        boolean locked = false;
        locked = lock.tryLock();
        System.out.println("locked:" + locked);
        System.out.println("method m2 is invoked!");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("method m2 is finished!");
        if(locked){
            System.out.println("locked is unlocked!");
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        new Thread(() -> {
            new ReentrantLockTest2().m1();
        }).start();
        new Thread(() -> {
            new ReentrantLockTest2().m2();
        }).start();
    }
}
