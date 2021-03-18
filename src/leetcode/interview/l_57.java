package leetcode.interview;

import java.util.ArrayList;
import java.util.Arrays;

public class l_57 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 4, 7, 11, 16};
        int target = 10;
        System.out.println(Arrays.toString(FindNumbersWithSum(nums, target).toArray()));
    }

    public static ArrayList<Integer> FindNumbersWithSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        int tmp = nums[nums.length - 1] + 1;
        int res1 = nums[nums.length - 1] + 1, res2 = nums[nums.length - 1] + 1;
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum == target) {
                if (nums[i] * nums[j] < res1 * res2) {
                    res1 = nums[i];
                    res2 = nums[j];
                }
                i++;
                j--;
            } else if (sum > target) {
                j--;
            } else {
                i++;
            }
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (res1 != tmp) {
            arrayList.add(res1);
            arrayList.add(res2);
        }
        return arrayList;
    }
}
