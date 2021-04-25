package cyc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class l_667 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2, 3, 1};
        System.out.println(findShortestSubArray(nums));
    }

    private static int max = 0;

    public static int findShortestSubArray(int[] nums) {
        List<Integer> tmp = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        backtrack(nums, tmp, visited);
        return max;
    }

    private static void backtrack(int[] nums, List<Integer> tmp, boolean[] visited) {
        System.out.println(Arrays.toString(tmp.toArray()));

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            tmp.add(nums[i]);
            backtrack(nums, tmp, visited);
            tmp.remove(tmp.size() - 1);
            visited[i] = false;
        }
    }
}
