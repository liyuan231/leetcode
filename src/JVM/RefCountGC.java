package JVM;

public class RefCountGC {
    private byte[] _5M = new byte[1024 * 1024 * 5];

    Object reference = null;

    public static void main(String[] args) throws InterruptedException {
        RefCountGC refCountGC1 = new RefCountGC();
        RefCountGC refCountGC2 = new RefCountGC();
        refCountGC1.reference = refCountGC2;
        refCountGC2.reference = refCountGC1;
        refCountGC1 = null;
        refCountGC2 = null;
//        System.gc();
        Thread.sleep(100000);
    }
}
