package algorithm;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class test {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        int[] nums = new int[]{0,0,0};
//        twoSum(nums,9);
        List<List<Integer>> lists = threeSum(nums);
        for (List<Integer> list : lists) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }

    public static void twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(target - nums[i]) != null) {
                System.out.println(nums[i] + "+" + (target - nums[i]) + "=" + target);
            } else {
                map.put(nums[i], i);
            }
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int N = nums.length;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (Arrays.binarySearch(nums, -nums[i] - nums[j]) > j) {
                    System.out.println(nums[i] + "+" + nums[j] + "+" + (-nums[i] - nums[j]) + "=" + 0);
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[j]);
                    tmp.add(-nums[i] - nums[j]);
                    result.add(new ArrayList<>(tmp));
                }
            }
        }
        return result;
    }
}
