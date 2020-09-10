package algorithm.sort;

import java.util.Arrays;

/**
 * 自顶向下的归并排序
 */
public class Merge {
    private static Comparable[] copy;

    public static void sort(Comparable[] a) {
        copy = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int left, int right) {
        if (right <= left) {
            return;
        }
        int mid = left + (right - left) / 2;
        sort(a, left, mid);
        sort(a, mid + 1, right);
        merge(a, left, mid, right);
    }


    private static void merge(Comparable[] a, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        for (int k = left; k <= right; k++) {
            copy[k] = a[k];
        }
        for (int k = left; k <= right; k++) {
            if (i > mid) {
                a[k] = copy[j++];
            } else if (j > right) {
                a[k] = copy[i++];
            } else if (copy[j].compareTo(copy[i]) < 0) {
                a[k] = copy[j++];
            } else {
                a[k] = copy[i++];
            }
        }
    }

    public static void main(String[] args) {
        Integer[] integers = new Integer[16];
        for (int i = 0; i < integers.length; i++) {
            integers[i] = (int) (Math.random() * 100);
        }
        Merge.sort(integers);
        System.out.println(Arrays.toString(Arrays.stream(integers).toArray()));
    }
}
