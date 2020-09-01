package JVM;

import java.lang.ref.SoftReference;

/**
 * 软引用，内存不足则回收
 */
public class SoftReferenceTest {
    public static void main(String[] args) {
        Student student = new Student();
        System.out.println(student);
        SoftReference<Student> studentSoftReference = new SoftReference<>(new Student());
        System.out.println(studentSoftReference.get());
        try {
            byte[]_10M = new byte[10*1024*1024];
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }finally {
            System.out.println();
            System.out.println(student);
            System.out.println(studentSoftReference.get());

        }

    }
}
