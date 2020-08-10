package threads;

public class JoinTest {
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            for(int i=0;i<100;i++){
                System.out.println("t111->"+i);
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                //                    t1.join();
                for(int i=0;i<100;i++){
                    System.out.println("t222->"+i);
                }
            }
        });
        t1.start();
        t2.start();
    }
}
