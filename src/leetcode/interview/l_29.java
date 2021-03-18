package leetcode.interview;

import java.util.ArrayList;
import java.util.Arrays;

public class l_29 {
    public static void main(String[] args) {
        int[][] nums = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
        };
        System.out.println(Arrays.toString(printMatrix(nums).toArray()));

    }

    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        int i0 = 0, j0 = 0, i1 = matrix[0].length - 1, j1 = matrix.length - 1;
        ArrayList<Integer> res = new ArrayList<>();
        while (true) {
            for (int i = i0; i <= i1; i++) {
                res.add(matrix[i0][i]);
            }
            if (++j0 > j1) {
                break;
            }
            for (int i = j0; i <= j1; i++) {
                res.add(matrix[i][i1]);
            }
            if (--i1 < i0) {
                break;
            }
            for (int i = i1; i >= i0; i--) {
                res.add(matrix[j1][i]);
            }
//            i0++;
            if (--j1 < j0) {
                break;
            }
            for (int i = j1; i >= j0; i--) {
                res.add(matrix[i][i0]);
            }
            if (++i0 > i1) {
                break;
            }

        }
        return res;
    }
}
