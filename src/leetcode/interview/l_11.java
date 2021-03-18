package leetcode.interview;

public class l_11 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 4, 1};
        System.out.println(minNumberInRotateArray(nums));
    }

    public static int minNumberInRotateArray(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] <= nums[hi]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return nums[lo];
    }
}
