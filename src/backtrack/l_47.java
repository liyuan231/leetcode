package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class l_47 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 2};
        System.out.println(Arrays.toString(permuteUnique(nums).toArray()));
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        List<Integer> tmp = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        boolean[] status = new boolean[nums.length];
        backtrack(nums, tmp, res, status);
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
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    private static void backtrack(int[] nums, List<Integer> tmp, List<List<Integer>> res, boolean[] status) {
        if (tmp.size() == nums.length) {
            res.add(new ArrayList<>(tmp));
            System.out.println(Arrays.toString(tmp.toArray()));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (status[i] || i > 0 && nums[i] == nums[i - 1] && !status[i - 1]) {
                continue;
            }
            status[i] = true;
            tmp.add(nums[i]);
            backtrack(nums, tmp, res, status);
            tmp.remove(tmp.size() - 1);
            status[i] = false;
        }
    }
}
