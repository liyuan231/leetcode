package leetcode;

import java.util.Arrays;

public class l_167__ {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 9, 11};
        int[] ints = twoSum(nums, 9);
        System.out.println(Arrays.toString(Arrays.stream(ints).toArray()));
    }

    public static int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return null;
    }
}
