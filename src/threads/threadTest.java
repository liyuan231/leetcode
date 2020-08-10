package threads;

public class threadTest {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<100;i++){
                    System.out.println("new Thread-lamda调用！"+i);
                }
            }
        }).start();
        new Thread(new MyThread()).start();
        new Thread(new MyRunnable()).start();
    }
    static class MyThread extends Thread{
        @Override
        public void run() {
//            super.run();
            for(int i=0;i<100;i++){
                System.out.println("Mythread调用！"+i);
            }
        }
    }
     static class MyRunnable implements Runnable{
        @Override
        public void run() {
            for(int i=0;i<100;i++){
                System.out.println("MyRunnable调用！"+i);
            }
        }
    }
}
