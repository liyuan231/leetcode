package leetcode;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 7, 9,  2, 4, 6, 8};
        sort(nums);

        System.out.println(Arrays.toString(Arrays.stream(nums).toArray()));
    }

    private static void sort(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid = (left + (right - left) / 2) + 1;

        int[] copy = new int[nums.length];
        for (int k = left; k <= right; k++) {
            copy[k] = nums[k];
        }

        int k = left;
        int i = left;
        int j = mid + 1;
        while (i <= mid && j <= right) {
            if (copy[i] < copy[j]) {
                nums[k++] = copy[i++];
            } else {
                nums[k++] = copy[j++];
            }
        }
        while (i <= mid) {
            nums[k++] = copy[i++];
        }
        while (j <= right) {
            nums[k++] = copy[j++];
        }

    }
}
