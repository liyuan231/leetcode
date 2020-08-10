package JVM;

import java.util.ArrayList;

public class HeapOOM {
    byte[] _1MB = new byte[1024 * 1024];

    public static void main(String[] args) {
        ArrayList<HeapOOM> list = new ArrayList<>();
        int count = 0;
//        while (true){
//            list.add(new HeapOOM());
//        }
        throw new NullPointerException();
    }

}
