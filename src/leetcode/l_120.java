package leetcode;

import java.util.ArrayList;
import java.util.List;

public class l_120 {
    public static void main(String[] args) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(2);
        lists.add(list1);
        list1 = new ArrayList<>();
        list1.add(3);
        list1.add(4);
        lists.add(list1);
        list1 = new ArrayList<>();
        list1.add(6);
        list1.add(5);
        list1.add(7);
        lists.add(list1);
        list1 = new ArrayList<>();
        list1.add(4);
        list1.add(1);
        list1.add(8);
        list1.add(3);
        lists.add(list1);
//        System.out.println(minimumTotal(lists));
        System.out.println(minimumTotal2(lists));
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (j == 0) {
                    triangle.get(i).set(j, triangle.get(i).get(j) + triangle.get(i - 1).get(j));
                } else if (j == triangle.get(i).size() - 1) {
                    triangle.get(i).set(j, triangle.get(i).get(j) + triangle.get(i - 1).get(j - 1));
                } else {
                    triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i - 1).get(j), triangle.get(i - 1).get(j - 1)));
                }
            }
        }
        int min = Integer.MAX_VALUE;
        List<Integer> list = triangle.get(triangle.size() - 1);
        for (Integer integer : list) {
            min = Math.min(integer, min);
        }
        return min;
    }

    public static int minimumTotal2(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] nums = new int[n][];
        int i = 0;
        for (List<Integer> list : triangle) {
            nums[i] = new int[list.size()];
            int j = 0;
            for (Integer integer : list) {
                nums[i][j++] = integer;
            }
            i++;
        }
        for (i = 1; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                if (j == 0) {
                    nums[i][j] = nums[i - 1][j] + nums[i][j];
                } else if (j == nums[i].length-1) {
                    nums[i][j] = nums[i - 1][j - 1] + nums[i][j];
                } else {
                    nums[i][j] = nums[i][j] + Math.min(nums[i - 1][j - 1], nums[i - 1][j]);
                }
            }
        }
        int min = nums[n - 1][0];
        for (i = 1; i < nums[n - 1].length; i++) {
            min = Math.min(min,nums[n-1][i]);
        }
        return min;
    }
}
