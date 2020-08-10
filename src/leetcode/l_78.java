package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class l_78 {
    public static void main(String[] args) {
        int[]nums = new int[]{1,2,3};
        List<List<Integer>> subsets = subsets(nums);
        for (List<Integer> subset : subsets) {
            System.out.println(Arrays.toString(subset.toArray()));
        }
    }
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length==0){return result;}
        LinkedList<Integer> curList = new LinkedList<>();
        backtrack(result,curList,nums,0);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, LinkedList<Integer> curList, int[] nums, int curIndex) {
//        System.out.println(Arrays.toString(curList.toArray()));
        result.add(new ArrayList<>(curList));
        for(int i =curIndex;i<nums.length;i++){
            curList.add(nums[i]);
            backtrack(result,curList,nums,i+1);
            curList.removeLast();
        }
    }
}
