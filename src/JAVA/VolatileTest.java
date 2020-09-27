package JAVA;

public class VolatileTest {
    private volatile int num = 0;

    private  void inc() {
        num++;
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileTest volatileTest = new VolatileTest();
        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    volatileTest.inc();
                }
            }).start();
        }
//        Thread.sleep(2000);
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println("num:" + volatileTest.num);
    }
}
