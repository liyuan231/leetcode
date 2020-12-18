package algorithm.sort;

import java.util.Comparator;

public class Insertion {
    public static void main(String[] args) {
        Double[] doubles = new Double[10];
        for (int i = 0; i < doubles.length; i++) {
            doubles[i] = Math.random() * doubles.length;
        }
        Insertion.sort(doubles);
        for (Double aDouble : doubles) {
            System.out.println(aDouble);
        }
    }

    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j].compareTo(a[j - 1]) > 0) {
                    continue;
                } else {
                    Comparable tmp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = tmp;
                }
            }
        }
    }

    public static void sort(Object[] a, Comparator comparator) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && less(comparator, a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
        }
    }

    private static boolean less(Comparator c, Object v, Object w) {
        return c.compare(v, w) < 0;
    }

    private static void exch(Object[] a, int i, int j) {
        Object t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
