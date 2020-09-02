package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class l_119 {
    public static void main(String[] args) {
        int n = 2;
        List<Integer> row = getRow(n);
        System.out.println(Arrays.toString(row.toArray()));
    }

    public static List<Integer> getRow(int rowIndex) {
        int[] prev;
        int[] cur = new int[rowIndex+1];
        for (int i = 0; i < rowIndex+1; i++) {
            prev = Arrays.copyOf(cur, cur.length);
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    cur[j] = 1;
                } else {
                    cur[j] = prev[j - 1] + prev[j];
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i : cur) {
            result.add(i);
        }
        return result;
    }
}
