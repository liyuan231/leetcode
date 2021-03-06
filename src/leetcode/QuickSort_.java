package leetcode;

import java.util.Arrays;

public class QuickSort_ {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 38, 10, 5, 7, 6, 34, 49, 2};
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    private static void quickSort(int[] nums, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int par = partion(nums, lo, hi);
        quickSort(nums, lo, par - 1);
        quickSort(nums, par + 1, hi);
    }

    private static int partion(int[] nums, int lo, int hi) {
        int i = lo, j = hi + 1;
        int num = nums[lo];
        while (true) {
            while (i != hi && nums[++i] < num) {
            }
            while (j != lo && nums[--j] > num) {
            }
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, lo, j);
        return j;
    }

    private static void swap(int[] nums, int lo, int j) {
        int tmp = nums[lo];
        nums[lo] = nums[j];
        nums[j] = tmp;
    }
}
