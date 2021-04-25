package dp;

import java.util.Arrays;

public class l_764 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(minCostClimbingStairs(nums));
    }

    public static int minCostClimbingStairs(int[] cost) {
        int[] book = new int[cost.length];
        book[0] = cost[0];
        book[1] = cost[1];
        for (int i = 2; i < book.length; i++) {
            book[i] = cost[i] + Math.min(book[i - 1], book[i - 2]);
        }
        System.out.println(Arrays.toString(Arrays.stream(book).toArray()));
        return Math.min(book[book.length - 1], book[book.length - 2]);
    }
}
