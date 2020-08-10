package threads;

import java.util.ArrayList;
import java.util.List;

public class VolatileTest {
    private volatile  int count=0;
    public  void m(){
        for(int i=0;i<10000;i++){
            count++;
        }
    }

    public static void main(String[] args) {
        VolatileTest volatileTest = new VolatileTest();
        List<Thread> threads = new ArrayList<>();
        for(int i=0;i<10;i++){
            threads.add(new Thread(volatileTest::m));
        }
        threads.forEach(Thread::start);
        threads.forEach(o->{
            try {
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(volatileTest.count);
    }
}
