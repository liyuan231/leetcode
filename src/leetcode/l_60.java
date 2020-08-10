package leetcode;

import java.util.*;

public class l_60 {
    public static void main(String[] args) {
        int n = 9, k = 9999 ;
        System.out.println("ans:" + getPermutation(n, k));

    }

    public static String getPermutation(int n, int k) {
        if (n == 0) {
            return "";
        }
        ArrayList<String> ans = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        backtrack(n,k, ans, stringBuilder);
        return ans.get(k-1);
    }

    private static void backtrack(int n, int k,List<String> ans, StringBuilder stringBuilder) {
        if (ans.size() == k) {
            return;
        }

        if (stringBuilder.length() == n) {
//            System.out.println(stringBuilder);
            ans.add(stringBuilder.toString());
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (stringBuilder.indexOf(String.valueOf(i)) == -1) {
                stringBuilder.append(i);
                backtrack(n,k, ans, stringBuilder);
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
        }
    }
}
