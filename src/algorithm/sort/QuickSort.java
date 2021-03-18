package algorithm.sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        Integer[] nums = new Integer[]{1, 2, 3, 578, -1, 32, 21, 54, 7, 23, 897};
        sort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(Arrays.stream(nums).toArray()));
    }

    private static void sort(Integer[] nums, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int j = partion(nums, lo, hi);
        sort(nums, lo, j - 1);
        sort(nums, j + 1, hi);
    }

    private static int partion(Comparable[] nums, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        Comparable num = nums[lo];
        while (true) {
            while (nums[++i].compareTo(num) < 0 && i != hi) {
            }
            while (nums[--j].compareTo(num) > 0 && j != lo) {
            }
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, lo, j);
        return j;
    }

    private static void swap(Comparable[] nums, int i, int j) {
        Comparable tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


}

