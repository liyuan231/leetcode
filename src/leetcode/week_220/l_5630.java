package leetcode.week_220;

import java.util.*;

public class l_5630 {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 2, 1, 2, 5, 2, 1, 2, 5};
        nums = new int[]{4, 2, 4, 5, 6};
//        nums = new int[]{28, 7320, 3661, 3458, 8708, 7632, 7434, 4643, 2694, 2619, 4665, 896, 2550, 4881, 7080, 3373, 3160, 4852, 4296, 1764, 9745, 432, 9191, 7257, 5325, 1612};
//        nums = new int[]{187, 470, 25, 436, 538, 809, 441, 167, 477, 110, 275, 133, 666, 345, 411, 459, 490, 266, 987, 965, 429, 166, 809, 340, 467, 318, 125, 165, 809, 610, 31, 585, 970, 306, 42, 189, 169, 743, 78, 810, 70, 382, 367, 490, 787, 670, 476, 278, 775, 673, 299, 19, 893, 817, 971, 458, 409, 886, 434};
        System.out.println(nums.length);
        System.out.println(maximumUniqueSubarray2(nums));
        System.out.println(maximumUniqueSubarray3(nums));
    }

    public static int maximumUniqueSubarray(int[] nums) {
        Arrays.sort(nums);
        nums = solve(nums);
        List<Integer> list = new LinkedList<>();
        return backtrack(nums, list, 0, 0);
    }

    private static int[] solve(int[] nums) {
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[j] != nums[i]) {
                nums[++j] = nums[i];
            }
        }
        return Arrays.copyOf(nums, j + 1);
    }

    private static int backtrack(int[] nums, List<Integer> list, int index, Integer max) {
        if (index == nums.length) {
            System.out.println(Arrays.toString(list.toArray()));
            return Math.max(max, sum(list));
        }
        for (int i = index; i < nums.length; i++) {
            if (list.size() != 0 && list.get(list.size() - 1) == nums[i]) {
                continue;
            }
            list.add(nums[i]);
            max = Math.max(backtrack(nums, list, i + 1, max), max);
            list.remove(list.size() - 1);
        }
        return max;
    }

    private static int sum(List<Integer> result) {
        if (result == null) {
            return 0;
        }
        int sum = 0;
        for (Integer integer : result) {
            sum += integer;
        }
        return sum;
    }


    /**
     * 一次遍历的前缀hash看不懂....
     *
     * @param nums
     * @return
     */
    public static int maximumUniqueSubarray2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] preSum = new int[nums.length];
        preSum[0] = nums[0];
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i];
        }
        System.out.println(Arrays.toString(Arrays.stream(preSum).toArray()));
        int sum = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (map.containsKey(nums[right]) && map.get(nums[right]) >= left) {
                left = map.get(nums[right]) + 1;
            }
            sum = Math.max(sum, preSum[right] - (left == 0 ? 0 : preSum[left - 1]));
            map.put(nums[right], right);
        }
        return sum;
    }

    public static int maximumUniqueSubarray3(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        int max = 0;
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
                sum += nums[i];
                max = Math.max(max, sum);
            } else {
                while (nums[i] != nums[start]) {
                    sum -= nums[start];
                    set.remove(nums[start++]);
                }
                start++;
            }

        }
        return max;
    }
}
