package JVM.GC;

import java.util.ArrayList;

public class GCLogsTest {
    private static byte[] _1MB = new byte[1024];

    public static void main(String[] args) throws InterruptedException {
        ArrayList<byte[]> list = new ArrayList<>();
        for (int i = 0; i < 500; i++) {
            byte[] arr = new byte[1024 * 10];
            list.add(arr);
            Thread.sleep(10);
        }
    }
}
