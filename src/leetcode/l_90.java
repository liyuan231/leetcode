package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class l_90 {
    public static void main(String[] args) {
        int[] nums = new int[]{4,4,4,1,4};
        List<List<Integer>> lists = subsetsWithDup(nums);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        LinkedList<Integer> curList = new LinkedList<>();
        List<List<Integer>> result = new LinkedList<>();
        backtrack(nums, result, curList, 0);
        return result;
    }

    private static void backtrack(int[] nums, List<List<Integer>> result, LinkedList<Integer> curList, int index) {
//        System.out.println(Arrays.toString(curList.toArray()));
        result.add(new LinkedList<>(curList));
        for (int i = index; i < nums.length; i++) {
//            同层去重
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            curList.add(nums[i]);
            backtrack(nums, result, curList, i + 1);
            curList.removeLast();
        }
    }
}
