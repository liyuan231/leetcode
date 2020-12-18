package leetcode;

import java.util.List;

public class l_220 {
    public static void main(String[] args) {
        int[] nums = new int[]{-2147483648, 2147483647};
        int k = 1;
        int t = 1;
        System.out.println(containsNearbyAlmostDuplicate(nums, k, t));
    }

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        return false;
    }

    public static boolean containsNearbyDuplicate2(List<Integer> nums, int k) {
//        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.size() - 1; i++) {
            Integer num0 = nums.get(i);
            Integer num1 = nums.get(i + 1);
            if (num1 - num0 <= k) {
                return true;
            }
        }
        return false;
    }
}
