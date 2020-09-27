package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class l_167 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int[] ints = twoSum(nums, 9);
        System.out.println(Arrays.toString(Arrays.stream(ints).toArray()));
    }

    public static int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int difference = target - numbers[i];
            if (map.get(difference) != null) {
                int i1 = i;
                int i2 = map.get(difference);
                if (i1 > i2) {
                    return new int[]{i2, i1};
                }
                return new int[]{i1, i2};
            } else {
                map.put(numbers[i], i);
            }
        }
        return null;
    }
}
