package interpret;

import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class QuickSort {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 10, 3, 8, 5, 6, 7, 4, 9, 2};
        sort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(Arrays.stream(nums).toArray()));


        ThreadPoolExecutor executor = new ThreadPoolExecutor(4, 8, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10), new ThreadPoolExecutor.AbortPolicy());
    }


    private static void sort(int[] nums, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int par = partion(nums, lo, hi);
        sort(nums, lo, par - 1);
        sort(nums, par + 1, hi);
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
        int t = nums[lo];
        nums[lo] = nums[j];
        nums[j] = t;
    }
}
