package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class l_1 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        nums = new int[]{3,3};
        int target = 6;
        System.out.println(Arrays.toString(solve(nums, target)));
    }

    private static int[] solve(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(target - nums[i]) == null) {
                map.put(nums[i], i);
            } else {
                return new int[]{ map.get(target - nums[i]),i};
            }
        }
        return null;
    }
}
