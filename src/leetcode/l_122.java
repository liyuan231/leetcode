package leetcode;

public class l_122 {
    public static void main(String[] args) {
        int[]nums = new int[]{7,1,5,3,6,4};
        System.out.println(maxProfit(nums));
    }
    public static int maxProfit(int[] prices) {
        int[][]book = new int[prices.length][2];
        book[0][0] = 0;
        /**
         * buy
         */
        book[0][1] = -prices[0];
        for(int i=1;i<prices.length;i++){
            book[i][0] = Math.max(book[i-1][0],book[i-1][1] + prices[i]);
            book[i][1] = Math.max(book[i-1][1],book[i-1][0] - prices[i]);
        }
        return book[book.length-1][0];
    }
}
