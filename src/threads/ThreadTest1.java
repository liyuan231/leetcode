package threads;

public class ThreadTest1 {
    private   boolean running = true;

    void m() {
        System.out.println("method m is invoked!");
        while (running) {

        }
        System.out.println("method m is finished!");
    }

    public static void main(String[] args) {
        ThreadTest1 threadTest1 = new ThreadTest1();
        new Thread(threadTest1::m, "threadTest1").start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadTest1.running = false;
    }
}
