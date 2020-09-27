package leetcode;

import java.util.Arrays;

public class l_167_ {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        System.out.println(Arrays.toString(Arrays.stream(twoSum(nums, 23)).toArray()));
    }

    public static int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length - 1; i++) {
            int difference = target - numbers[i];
            int i1 = find(numbers, difference, i + 1);
            if (i1 != -1) {
                return new int[]{i, i1};
            }
        }
        return null;
    }

    private static int find(int[] numbers, int target, int start) {
        int left = start;
        int right = numbers.length;
        int mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (numbers[mid] == target) {
                return mid;
            } else if (numbers[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }


}
