package JVM.OOM;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.Arrays;

public class DirectMemoryOOM {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) throws IllegalAccessException {
        Field[] unsafeFields = Unsafe.class.getDeclaredFields();
        System.out.println(Arrays.toString(Arrays.stream(unsafeFields).toArray()));
        Field unsafeField = unsafeFields[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while (true) {
            unsafe.allocateMemory(_1MB);
        }


    }
}

