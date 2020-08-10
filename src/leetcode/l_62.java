package leetcode;

import java.util.Arrays;

public class l_62 {
    public static void main(String[] args) {
        System.out.println(uniquePaths(7, 3));
    }

    public static int uniquePaths(int m, int n) {
        int[][] book = new int[n][m];
        for (int i = 0; i < book.length; i++) {
            for (int j = 0; j < book[i].length; j++) {
                if (i == 0 || j == 0) {
                    book[i][j] = 1;
                } else {
                    book[i][j] = book[i - 1][j] + book[i][j - 1];
                }
            }
        }
        for (int i = 0; i < book.length; i++) {
            for (int j = 0; j < book[i].length; j++) {
                System.out.print(book[i][j] + " ");
            }
            System.out.println();
        }
        return book[book.length - 1][book[0].length - 1];
    }
}
