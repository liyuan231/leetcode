package JAVA;

import java.util.concurrent.BlockingQueue;

public class ThreadTest {
    public static void main(String[] args) {
        System.out.println(Thread.activeCount());
        Thread[]threads = new Thread[10];
        int enumerate = Thread.enumerate(threads);
        for(Thread thread:threads){
            System.out.println(thread+":"+thread.getId()+"->"+thread.getName()+"->"+thread.getPriority());
        }
//        BlockingQueue
//        Thread.currentThread().is.
    }
}
