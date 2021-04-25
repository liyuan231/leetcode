package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class l_216 {
    public static void main(String[] args) {
        int k = 3, n = 9;
        System.out.println(Arrays.toString(combinationSum3(k, n).toArray()));
    }

    public static List<List<Integer>> combinationSum3(int k, int sum) {
        List<Integer> tmp = new ArrayList<>(k);
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[10];
        backtrack(1,tmp, res, sum, 0, k, visited);
        return res;
    }

    private static void backtrack(int curIndex,List<Integer> tmp, List<List<Integer>> res, int sum, int curSum, int limitSize, boolean[] visited) {
        if (tmp.size() == limitSize && sum == curSum) {
//            System.out.println(Arrays.toString(tmp.toArray()));
            res.add(new ArrayList<>(tmp));
        }

        for (int i = curIndex; i <= 9; i++) {
//            if (visited[i]) {
//                continue;
//            }
            tmp.add(i);
//            visited[i] = true;
            backtrack(i+1,tmp, res, sum, curSum + i, limitSize, visited);
//            visited[i] = false;
            tmp.remove(tmp.size() - 1);
        }
    }


}
