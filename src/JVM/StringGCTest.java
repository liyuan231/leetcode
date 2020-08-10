package JVM;

/**
 * 测试String的垃圾回收
 * -Xms15m -Xmx15m -XX:+PrintStringTableStatistics -XX:+PrintGCDetails(-Xlog)
 */
public class StringGCTest {
    private static final String s = "liyuan";
    public static void main(String[] args) throws InterruptedException,NullPointerException {
        for (int i = 0; i < 100000; i++) {
            String.valueOf(i).intern();
        }
        Thread.sleep(1000);
        try {
            int i = 0;
        } catch (NullPointerException exception) {
            throw exception;
        }
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}
