package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class l_219 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 1, 2, 3};
        int k = 3;
        System.out.println(containsNearbyDuplicate(nums, k));
        System.out.println(containsNearbyDuplicate2(nums, k));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, ArrayList<Integer>> arrayListHashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            ArrayList<Integer> orDefault = arrayListHashMap.getOrDefault(nums[i], new ArrayList<>());
            orDefault.add(i);
            arrayListHashMap.put(nums[i], orDefault);
        }
        for (Map.Entry<Integer, ArrayList<Integer>> entry : arrayListHashMap.entrySet()) {
            ArrayList<Integer> values = entry.getValue();
            for (int i = 0; i < values.size() - 1; i++) {
                if (Math.abs(values.get(i + 1) - values.get(i)) <= k) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean containsNearbyDuplicate2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer index = map.get(nums[i]);
            if (index == null) {
                map.put(nums[i], i);
                continue;
            }
            if (i - index <= k) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }
}
