package leetcode.week_220;

import java.util.Arrays;
import java.util.PriorityQueue;

public class l_5631 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, -1, -2, 4, -7, 3};
//        nums = new int[]{10,-5,-2,4,0,3};
//        nums = new int[]{1,-5,-20,4,-1,3,-6,-3};
        int k = 2;
        System.out.println(maxResult(nums, k));
    }

    public static int maxResult(int[] nums, int k) {
        int[] book = new int[nums.length];
        book[0] = nums[0];
        int max;
        for (int i = 1; i < nums.length; i++) {
            max = book[i - 1];
            for (int j = i - 2; j >= (i - k) && j >= 0; j--) {
                if (book[j] > max) {
                    max = book[j];
                }
                if (nums[j] > 0) {
                    break;
                }
            }
            book[i] = max + nums[i];
        }
//        System.out.println(Arrays.toString(Arrays.stream(book).toArray()));
        return book[book.length - 1];
    }


}
