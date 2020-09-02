package leetcode;

public class l_121 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 1, 4};
        System.out.println(maxProfit3(nums));
    }

    public static int maxProfit(int[] prices) {
        int[] book = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j < i; j++) {
                book[i] = Math.max(book[i], prices[i] - prices[j]);
            }
        }
        int max = book[0];
        for (int i = 1; i < book.length; i++) {
            max = Math.max(max, book[i]);
            System.out.print(book[i] + " ");
        }
        System.out.println();
        return max;
    }

    public static int maxProfit2(int[] nums) {
        int[][] book = new int[nums.length][2];
        /**
         * 0:sell stock
         * 1:buy stock
         */
        book[0][1] = -nums[0];
        book[0][0] = 0;
        for (int i = 1; i < nums.length; i++) {
            book[i][0] = Math.max(book[i - 1][0], book[i - 1][1] + nums[i]);
            book[i][1] = Math.max(book[i - 1][1], -nums[i]);
        }
        return book[nums.length - 1][0];
    }

    public static int maxProfit3(int[] nums) {
        /**
         * 到i之前最便宜的股票
         */
        int min = nums[0];
        /**
         * 最大获利
         */
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i] - min);
            min = Math.min(min, nums[i]);
        }
        return max;
    }
}
