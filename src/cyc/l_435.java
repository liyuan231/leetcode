package cyc;

import java.util.Arrays;
import java.util.Comparator;

public class l_435 {
    public static void main(String[] args) {
        int[][] nums = new int[][]{
                {1, 2}, {2, 3}, {3, 4}, {1, 3}
        };
        System.out.println(eraseOverlapIntervals(nums));
    }

    /**
     * 求出不重叠的个数，使用总个数减去不重叠的个数
     *
     * @param nums
     * @return
     */
    public static int eraseOverlapIntervals(int[][] nums) {
        Arrays.sort(nums, Comparator.comparingInt(o -> o[1]));
        int end = nums[0][1];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i][0] < end) {
                continue;
            }
            end = nums[i][1];
            count++;
        }
        return nums.length - count;

    }
}
