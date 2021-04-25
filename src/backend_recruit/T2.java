package backend_recruit;

public class T2 {
    public static void main(String[] args) {
        int[] nums = new int[]{50,40,30,20,10,900};
        System.out.println(solve(nums));
    }

    private static int solve(int[] nums) {
        int i = 0, j = nums.length - 1;
        int sum1 = 0;
        int sum2 = 0;
        while (i < j) {
            if (sum1 <= sum2) {
                sum1 += nums[i++];
            } else {
                sum2 += nums[j--];
            }
        }
        System.out.println("sum2:"+sum2);
        System.out.println("sum1:"+sum1);
        return Math.abs(sum1-sum2);

    }
}
