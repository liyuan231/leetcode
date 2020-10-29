package leetcode;

public class l_209 {
    public static void main(String[] args) {
        int s = 15;
        int[] nums = new int[]{1, 2, 3, 4, 5};
//        s = 7;
//        nums = new int[]{2, 3, 1, 2, 4, 3};
        System.out.println(minSubArrayLen(s, nums));
    }

    public static int minSubArrayLen(int s, int[] nums) {
        int ans = nums.length + 1;
        int i = 0, j = 0;
        int sum = 0;
        while (j < nums.length) {
            sum += nums[j];
            while (sum >= s) {
                ans = Math.min(ans, j - i + 1);
                sum -= nums[i];
                i++;
            }
            j++;
        }
        return ans;

    }


}
