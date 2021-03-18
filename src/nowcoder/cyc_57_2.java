package nowcoder;

import java.util.ArrayList;
import java.util.Arrays;

public class cyc_57_2 {
    public static void main(String[] args) {
        int n = 9;
        System.out.println(Arrays.toString(FindContinuousSequence(n).toArray()));
    }

    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int num) {
        ArrayList<Integer> tmp = new ArrayList<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        backtrack(num, tmp, 1, res, 0);
        return res;
    }

    private static void backtrack(int target, ArrayList<Integer> tmp, int currentIndex, ArrayList<ArrayList<Integer>> res, int sum) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = currentIndex; i < target; i++) {
            if (sum + i > target || (tmp.size() > 0 && !tmp.get(tmp.size() - 1).equals(i - 1))) {
                return;
            }
            tmp.add(i);
            backtrack(target, tmp, i + 1, res, sum + i);
            tmp.remove(tmp.size() - 1);
        }
    }
}
