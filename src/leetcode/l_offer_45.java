package leetcode;

import java.util.Arrays;

public class l_offer_45 {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 30, 34, 5, 9};
        System.out.println(minNumber(nums));
    }

    public static String minNumber(int[] nums) {
        sort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(Arrays.stream(nums).toArray()));
        StringBuilder res = new StringBuilder();
        for (int num : nums) {
            res.append(num);
        }
        return res.toString();
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
            while (i != hi) {
                i++;
                String n1 = nums[i] + String.valueOf(num);
                String n2 = num + String.valueOf(nums[i]);
                if (n1.compareTo(n2) > 0) {
                    break;
                }
            }
            while (j != lo) {
                j--;
                String n3 = nums[j] + String.valueOf(num);
                String n4 = String.valueOf(num) + nums[j];
                if (n3.compareTo(n4) < 0) {
                    break;
                }
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
