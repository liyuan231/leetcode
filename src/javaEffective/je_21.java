package javaEffective;

import java.util.function.Consumer;

public class je_21 {
    public static void main(String[] args) {

    }
}

abstract class t1 {

}

abstract class t2 extends t1 implements Comparable, Iterable {

}

interface test extends Comparable, Iterable, Cloneable {
    default void test() {
        System.out.println("test");
    }
}