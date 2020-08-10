package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class l_77_a {
    public static void main(String[] args) {
        combine(4, 2);
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> curList = new LinkedList<>();
        backtrack(result, curList, n, k, 1);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, LinkedList<Integer> curList, int n, int k, int curIndex) {
        if (curList.size() == k) {
            System.out.println(Arrays.toString(curList.toArray()));
            result.add(new LinkedList<>(curList));
            return;
        }
        for (int i = curIndex; i <= n; i++) {
//            if (curList.contains(i)) {
//                continue;
//            }
            curList.add(i);
            backtrack(result, curList, n, k, i+1);
            curList.removeLast();
        }
    }
}
