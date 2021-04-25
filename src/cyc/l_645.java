package cyc;

import java.util.Arrays;

public class l_645 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2, 4};
        nums = new int[]{3, 2, 3, 4, 6, 5};
        System.out.println(Arrays.toString(findErrorNums(nums)));
    }

    public static int[] findErrorNums(int[] nums) {
        int[] bucket = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            bucket[nums[i]]++;
        }
        int duplicate = -1;
        int missing = -1;
        for (int i = 1; i < bucket.length; i++) {
            if (bucket[i] == 2) {
                duplicate = i;
            } else if (bucket[i] == 0) {
                missing = i;
            }
        }
        return new int[]{duplicate,missing};
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
        swap(nums, j, lo);
        return j;

    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
