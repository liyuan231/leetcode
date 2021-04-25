package interview.huaiwei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class l_46 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> permute = permute(nums);
//        System.out.println(Arrays.toString(permute.toArray()));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> tmp = new ArrayList<Integer>();
        boolean[] visited = new boolean[nums.length];
        backtrack(visited, nums, tmp, res, 0);
        return res;
    }

    public static void backtrack(boolean[] visited, int[] nums, List<Integer> output, List<List<Integer>> res, int currentIndex) {
        // ��������������
        if (output.size() == nums.length) {
            System.out.println(Arrays.toString(output.toArray()));
            res.add(new ArrayList<Integer>(output));
        }
        for (int i = currentIndex; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            // ��̬ά������
//            Collections.swap(output, currentIndex, i);
            output.add(nums[i]);
            visited[i] = true;
            // �����ݹ�����һ����
            backtrack(visited, nums, output, res, currentIndex);
            visited[i] = false;
            output.remove(output.size() - 1);
            // ��������
//            Collections.swap(output, currentIndex, i);
        }
    }
}
