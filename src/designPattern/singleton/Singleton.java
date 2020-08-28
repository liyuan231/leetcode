package designPattern.singleton;

public class Singleton {
    private Singleton() {
    }

    private static final Singleton singletonPattern = new Singleton();

    public static Singleton getInstance() {
        return singletonPattern;
    }

    private Object readResolve() {
        return singletonPattern;
    }

}
