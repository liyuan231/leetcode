package algorithm.sort;

import java.util.Arrays;

/**
 * 自底向上的归并排序
 */
public class MergeUB {
    private static int count=0;
    private static Comparable[] copy;

    public static void sort(Comparable[] a) {
        int N = a.length;
        copy = new Comparable[N];
        for (int size = 1; size < N; size = size + size) {
            for (int left = 0; left < N - size; left += size + size) {
                merge(a, left, left + size - 1, Math.min(left + size + size - 1, N - 1));
            }
        }
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
                count+=mid-i+1;
            } else {
                a[k] = copy[i++];
            }
        }
    }

    public static void main(String[] args) {
        Integer[] integers = new Integer[]{7,5,6,4};
//        for (int i = 0; i < integers.length; i++) {
//            integers[i] = (int) (Math.random() * integers.length);
//        }
        MergeUB.sort(integers);
        System.out.println(Arrays.toString(Arrays.stream(integers).toArray()));
        System.out.println(count);
    }
}
