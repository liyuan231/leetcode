package dp;

import java.util.Arrays;

public class l_53 {
    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        int[] book = new int[nums.length];
        book[0] = nums[0];
        int max = book[0];
        for (int i = 1; i < nums.length; i++) {
            book[i] = (Math.max(book[i - 1], 0)) + nums[i];
            max = Math.max(max,book[i]);
        }
        System.out.println(Arrays.toString(Arrays.stream(book).toArray()));
        return max;
    }

}
