package backend_recruit;

public class T1 {
    public static void main(String[] args) {
        int[] nums = new int[]{1};
        System.out.println(solve(nums));
    }

    private static int solve(int[] nums) {
        int min = nums[0];
        int profit = 0;
        for (int i = 1; i < nums.length; i++) {
            profit = Math.max(profit,nums[i] -min);
            min = Math.min(min, nums[i]);
        }
        return profit;
    }

}
