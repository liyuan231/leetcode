package JAVA;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyService {
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public static void main(String[] args) {
        MyService myService = new MyService();
        myService.testMethod();
    }

    public void testMethod() {
        try {
            lock.lock();
            System.out.println("wait method is invoked!");
            condition.wait();
            Thread.sleep(3000);
            System.out.println("开始唤醒！");
            condition.signal();
            for (int i = 0; i < 5; i++) {
                System.out.println("ThreadName=" + Thread.currentThread().getName() + ("" + (i + 1)));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
