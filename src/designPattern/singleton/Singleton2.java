package designPattern.singleton;

public class Singleton2 {
    private static Singleton2 single = null;

    static {
        single = new Singleton2();
    }
    private Object readResolve(){
        return single;
    }
}
