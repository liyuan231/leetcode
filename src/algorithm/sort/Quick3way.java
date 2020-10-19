package algorithm.sort;

import java.util.Arrays;

public class Quick3way {
    public static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int lt = lo, i = lo + 1, gt = hi;
        Comparable v = a[lo];
        while (i < gt) {
            int cmp = a[i].compareTo(v);
            if (cmp < 0) {
                swap(a, lt++, i++);
            } else if (cmp > 0) {
                swap(a, i, gt--);
            } else {
                i++;
            }
        }
        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
    }

    private static void swap(Comparable[] a, int i, int i1) {
        Comparable tmp = a[i];
        a[i] = a[i1];
        a[i1] = tmp;
    }

    public static void main(String[] args) {
        Integer[] nums = new Integer[10];
        for (int i = 0; i < 10; i++) {
            nums[i] = (int) (Math.random() * 10);
        }
        System.out.println(Arrays.toString(Arrays.stream(nums).toArray()));
        Quick3way.sort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(Arrays.stream(nums).toArray()));
    }

}
