package cyc;

import java.util.Arrays;

public class l_128 {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        nums = new int[]{100, 4, 200, 1, 3, 2};
        nums = new int[]{1, 2, 0, 1};
        nums = new int[]{9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6};
        nums = new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println(longestConsecutive(nums));
    }

    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(Arrays.stream(nums).toArray()));
        nums = distinct(nums);
        System.out.println(Arrays.toString(Arrays.stream(nums).toArray()));
        int count = 1;
        int max = 1;
        int target = nums[0] + 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == target) {
                count++;
                target++;
            } else {
                max = Math.max(count, max);
                target = nums[i] + 1;
                count = 1;
            }
        }
        return Math.max(max,count);
    }

    private static int[] distinct(int[] nums) {
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[j]) {
                continue;
            }
            nums[++j] = nums[i];
        }
        int[] res = new int[j + 1];
        for (int i = 0; i < res.length; i++) {
            res[i] = nums[i];
        }
        return res;
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
