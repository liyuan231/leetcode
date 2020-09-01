package JVM;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

public class PhantomReferenceTest {
    public static void main(String[] args) {
        ReferenceQueue<Student> referenceQueue = new ReferenceQueue<>();
        Student student = new Student();
        PhantomReference<Student> phantomReference = new PhantomReference<>(student, referenceQueue);
        student = null;
//        phantomReference.
        System.out.println(phantomReference.get());
        System.gc();
        Reference<? extends Student> reference = null;
        while ((reference = referenceQueue.poll()) != null) {
            System.out.println("|->" + reference.get());
        }
    }
}
