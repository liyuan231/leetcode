package leetcode;

import java.util.Arrays;

public class l_198 {
    public static void main(String[] args) {
        int[] nums = new int[]{2,1,1,2};
        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] book = new int[nums.length];
        book[0] = nums[0];
        book[1] = nums[1];
        int max = 0;
        for (int i = 2; i < nums.length; i++) {
            max = Math.max(max, book[i - 2]);
            book[i] = nums[i] + max;
        }
        System.out.println(Arrays.toString(Arrays.stream(book).toArray()));
        max = Math.max(max, Math.max(book[book.length - 1], book[book.length - 2]));
        return max;
    }
}
