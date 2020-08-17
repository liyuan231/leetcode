package threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest3 {
    Lock lock = new ReentrantLock(false);
    public void run(){
        for(int i=0;i<3;i++){
            lock.lock();
            System.out.println(Thread.currentThread().getName()+"获得锁!");
            lock.unlock();
        }

    }

    public static void main(String[] args) {
        ReentrantLockTest3 reentrantLockTest3 = new ReentrantLockTest3();
        new Thread(reentrantLockTest3::run).start();
        new Thread(reentrantLockTest3::run).start();
        new Thread(reentrantLockTest3::run).start();
        new Thread(reentrantLockTest3::run).start();
        new Thread(reentrantLockTest3::run).start();
    }
}
