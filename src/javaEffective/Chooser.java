package javaEffective;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Chooser<T> {
    private final List<T> objects;

    public Chooser(Collection<T> choices) {
        this.objects = new ArrayList<T>(choices);
    }

    public Object choose() {
        ThreadLocalRandom current = ThreadLocalRandom.current();
        return objects.get(current.nextInt(objects.size()));
    }

    public static void main(String[] args) {
        Integer[] integers = new Integer[]{1, 2, 3, 4, 5};
        Chooser<Integer> chooser = new Chooser<Integer>(Arrays.asList(integers));
        System.out.println((String) chooser.choose());
    }
}
