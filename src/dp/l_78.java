package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class l_78 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        System.out.println(Arrays.toString(subsets(nums).toArray()));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<Integer> tmp = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        boolean visited[] = new boolean[nums.length];
        backtrack(tmp, res, nums, visited,0);
        return res;
    }

    private static void backtrack(List<Integer> tmp, List<List<Integer>> res, int[] nums, boolean[] visited,int curIndex) {
//        System.out.println(Arrays.toString(tmp.toArray()));
        res.add(new ArrayList<>(tmp));
        if (tmp.size() == nums.length) {
            return;
        }

        for (int i = curIndex; i < nums.length; i++) {
//            if(visited[i]){continue;}
            tmp.add(nums[i]);
//            visited[i] = true;
            backtrack(tmp, res, nums, visited,i+1);
//            visited[i] = false;
            tmp.remove(tmp.size() - 1);
        }


    }
}
