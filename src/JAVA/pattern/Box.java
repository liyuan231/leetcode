package JAVA.pattern;

import java.util.ArrayList;
import java.util.List;

public class Box<A, B, C, D> {
    public static void main(String[] args) {
        Box<?, ?, ?, ?> box = new Box<>();
        List<? extends Thread> list = new ArrayList<>();
    }

    public <E extends Thread> void test1(E e) {

    }

}
