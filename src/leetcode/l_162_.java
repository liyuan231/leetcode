package leetcode;

public class l_162_ {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 1, 3, 5, 6, 4};
//        nums = new int[]{1, 2, 3};
        nums = new int[]{1, 1};
        nums = new int[]{1, 3, 2, 1};
//        nums = new int[]{1, 2, 3, 1};
        System.out.println(findPeakElement(nums));
        System.out.println(findPeakElement_(nums));
        System.out.println(findPeak(nums));
    }

    public static int findPeakElement(int[] nums) {
        int i = 1;
        for (; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                break;
            }
        }
        return i - 1;
    }

    /**
     * 二分搜索
     *
     * @param nums
     * @return
     */
    public static int findPeakElement_(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] > nums[mid + 1]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    public static int findPeak(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int i = 0;
        int j = nums.length - 1;
        while (i++ <= j--) {
            if (nums[i] < nums[i - 1]) {
                return i - 1;
            }
            if (nums[j + 1] > nums[j]) {
                return j + 1;
            }
        }
        return i + j;
    }
}
