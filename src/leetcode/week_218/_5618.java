package leetcode.week_218;

import java.util.HashMap;
import java.util.Map;

public class _5618 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 5, 4, 4, 1, 3, 4, 4, 1, 4, 4, 1, 2, 1, 2, 2, 3, 2, 4, 2};
        int k = 3;
        System.out.println(maxOperations(nums, k));
    }

    public static int maxOperations(int[] nums, int k) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int target = k - nums[i];
            if (map.get(target) != null) {
                System.out.println(nums[i] + "+" + target);
                if(map.get(target)==1){
                    map.remove(target);
                }else {
                    map.put(target,map.get(target)-1);
                }
                res++;
            } else {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
        }
        return res;
    }
}
