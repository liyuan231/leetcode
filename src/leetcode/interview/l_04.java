package leetcode.interview;

public class l_04 {
    public static void main(String[] args) {
        int[][] nums = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        int target = 26;
        System.out.println(Find(target, nums));

    }

    public static boolean Find(int target, int[][] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (binarySearch(nums[i], target)) {
                return true;
            }
        }
        return false;
    }

    private static boolean binarySearch(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return false;
    }

}
