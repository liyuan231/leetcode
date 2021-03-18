package leetcode.interview;

public class l_53 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 3, 3, 3, 4};
//        nums = new int[]{2, 2,2,2};
        int target = 99;
        System.out.println(GetNumberOfK(nums, target));
    }

    public static int GetNumberOfK(int[] nums, int target) {
        int i = binarySearch_(nums, target);
        int j = binarySearch_(nums, target + 1);
        return (i == nums.length || nums[i] != target) ? 0 : j - i;
    }

    private static int binarySearch_(int[] nums, int target) {
        int lo = 0, hi = nums.length;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] >= target) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}
