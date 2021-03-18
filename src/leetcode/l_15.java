package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class l_15 {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
//        nums = new int[]{-2, 0, 0, 2, 2};
        System.out.println(Arrays.toString(threeSum(nums).toArray()));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
//        int cleanLength = clean(nums) +1;
        LinkedList<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            int lo = i + 1, hi = nums.length - 1;
            int target = -nums[i];
            while (lo < hi) {
                int sum = nums[lo] + nums[hi];
                if (sum == target) {
//                    System
//                  .out.println(nums[i] + "+" + nums[lo] + "+" + nums[hi]);
                    LinkedList<Integer> r = new LinkedList<>();
                    r.add(nums[i]);
                    r.add(nums[lo]);
                    r.add(nums[hi]);
                    res.add(r);
                    hi--;
                    lo++;
                } else if (sum > target) {
                    hi--;
                } else {
                    lo++;
                }
            }
        }
        return res;
//        System.out.println(Arrays.toString(Arrays.stream(nums).toArray()));
//        return null;
    }

//    private static int  clean(int[] nums) {
//        int i,j;
//        for ( i = 0, j = 0; i < nums.length; i++) {
//            if (nums[i] != nums[j]) {
//                j++;
//            }
//            nums[j] = nums[i];
//        }
//        return j;
//    }


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

    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
