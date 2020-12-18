package JVM.GC;

public class ReferenceCountingGC {
    public Object instance = null;
    private static final int _1MB = 1024*1024;
    private byte[] bigSize = new byte[2*_1MB];


    public static void main(String[] args) {
        ReferenceCountingGC instanceA = new ReferenceCountingGC();
        ReferenceCountingGC instanceB = new ReferenceCountingGC();
        instanceA.instance = instanceB;
//        instanceB.instance=instanceA;

        System.gc();;

    }
}
