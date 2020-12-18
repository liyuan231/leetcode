package javaEffective;

import java.time.Instant;

public class je_19 {
    public static void main(String[] args) {

    }
}

class Super {
    public Super() {
        overrideMe();
    }

    public void overrideMe() {
        System.out.println("override me!");
    }
}

final class Sub extends Super {
    private final Instant instant;

    public Sub() {
        instant = Instant.now();
    }

    @Override
    public void overrideMe() {
        System.out.println(instant);
    }

    public static void main(String[] args) {
        Sub sub = new Sub();
        sub.overrideMe();
    }
}
