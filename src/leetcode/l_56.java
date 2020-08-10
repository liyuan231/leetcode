package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class l_56 {
    public static void main(String[] args) {
        int[][] nums = new int[][]{
                {1,3},{2,6},{8,10},{15,18}
        };
        int[][] merge = merge(nums);
        for (int[] ints : merge) {
            System.out.println("[" + ints[0] + "," + ints[1] + "]");
        }
    }

    public static int[][] merge(int[][] nums) {
        if (nums.length == 0) {
            return nums;
        }
        Arrays.sort(nums, Comparator.comparingInt(o -> o[0]));
        List<int[]> result = new ArrayList<>();
        int x;
        int y;
        for (int i = 0; i < nums.length; i++) {
            x = nums[i][0];
            y = nums[i][1];
            while (i < nums.length - 1 && nums[i + 1][0] <= y) {
                y = Math.max(y,nums[i + 1][1]);
                i++;
            }
            result.add(new int[]{x, y});
        }
        return result.toArray(new int[0][]);
    }
}
