package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class l_77 {
    public static void main(String[] args) {
        int n = 4, k = 2;
        List<List<Integer>> combine = combine(n, k);
        System.out.println(Arrays.toString(combine.toArray()));
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<Integer> tmp = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        backtrack(n, k, res, tmp, 1);
        return res;
    }

    private static void backtrack(int n, int cap, List<List<Integer>> res, List<Integer> tmp, int curIndex) {
        if (tmp.size() == cap) {
//            System.out.println(Arrays.toString(tmp.toArray()));
            res.add(new ArrayList<>(tmp));
        }

        for (int i = curIndex; i <= n; i++) {
            tmp.add(i);
            backtrack(n, cap, res, tmp, i + 1);
            tmp.remove(tmp.size() - 1);
        }

    }
}
