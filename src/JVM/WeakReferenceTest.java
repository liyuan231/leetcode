package JVM;

import org.junit.Test;

import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/**
 * 弱引用，发现即回收
 */
public class WeakReferenceTest {
    public static void main(String[] args) throws InterruptedException {
        WeakReference<Student> studentWeakReference = new WeakReference<>(new Student());
        System.out.println(studentWeakReference.get());

        System.gc();

        System.out.println();
        System.out.println(studentWeakReference.get());

        System.out.println();
        WeakHashMap<Integer,String> weakHashMap = new WeakHashMap<>();
        for(int i=0;i<100;i++){
            weakHashMap.put(i,"i"+i);
        }
        Thread.sleep(1000);
        System.gc();
        System.out.println(weakHashMap);
        System.out.println(weakHashMap.size());
    }
    @Test public void weakHashMapTest(){
        WeakHashMap<Integer,String> weakHashMap = new WeakHashMap<>();
        for(int i=0;i<200;i++){
            weakHashMap.put(i,"i"+i);
        }
//        System.gc();
        System.out.println(weakHashMap);
    }
}
