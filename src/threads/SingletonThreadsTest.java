package threads;

public class SingletonThreadsTest {
    private SingletonThreadsTest() {
    }

    private static volatile SingletonThreadsTest singletonThreadsTest;

    public static SingletonThreadsTest getInstance() {
        if (singletonThreadsTest == null) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (SingletonThreadsTest.class) {
                if (singletonThreadsTest == null) {
                    synchronized (SingletonThreadsTest.class) {
                        singletonThreadsTest = new SingletonThreadsTest();
                    }
                }
            }
        }
        return singletonThreadsTest;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(SingletonThreadsTest.getInstance());
            }).start();
        }
    }

    public void test1() {
        Object o = new Object();
    }
}
