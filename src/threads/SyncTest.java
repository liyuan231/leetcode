package threads;

public class SyncTest implements Runnable {

    @Override
    public synchronized void run() {
        count--;
        System.out.println(Thread.currentThread() + ":" + this.count);
    }

    private int count;

    public static void main(String[] args) throws InterruptedException {
//        SyncTest syncTest = new SyncTest();
//        syncTest.count=100;
//        for(int i=0;i<100;i++){
//            new Thread(syncTest).start();
//        }
//        Thread.sleep(2000);
//        System.out.println(syncTest.count);
        SyncTest syncTest = new SyncTest();
        new Thread(() -> {
            try {
                syncTest.m1();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                syncTest.m2();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }


    public synchronized void m1() throws InterruptedException {
        for(int i=0;i<100;i++){
            System.out.println(Thread.currentThread() + "method m1 is invoked!->"+i);
        }
        System.out.println("m1 is finished!");
    }

    public void m2() throws InterruptedException {
        for(int i=0;i<100;i++){
            System.out.println(Thread.currentThread() + "method m2 is invoked!->"+i);
        }
        System.out.println("method m2 is finished!");
    }
}
