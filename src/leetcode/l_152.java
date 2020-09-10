package leetcode;

public class l_152 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, -2, 4};
        System.out.println(maxProduct(nums));
    }

    public static int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] maxs = new int[nums.length];
        maxs[0] = nums[0];
        int[] mins = new int[nums.length];
        mins[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxs[i] = Math.max(maxs[i - 1] * nums[i], Math.max(nums[i], mins[i - 1] * nums[i]));
            mins[i] = Math.min(mins[i - 1] * nums[i], Math.min(nums[i], maxs[i - 1] * nums[i]));
        }
//        System.out.println(Arrays.toString(Arrays.stream(maxs).toArray()));
//        System.out.println(Arrays.toString(Arrays.stream(mins).toArray()));
        int result = maxs[0];
        for (int max : maxs) {
            result = Math.max(max, result);

        }
        return result;
    }

}
