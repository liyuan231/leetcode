package leetcode;

public class l_162 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 1};
        nums = new int[]{3,2,1};
        System.out.println(findPeakElement(nums));
    }

    public static int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int i;
        for (i = 1; i < nums.length - 1; i++) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                return i;
            }
        }
        //单调递增或单调递减
        if (i == nums.length - 1) {
            if (nums[0] > nums[nums.length - 1]) {
                return 0;
            } else {
                return nums.length - 1;
            }
        }
        return -1;
    }
}
