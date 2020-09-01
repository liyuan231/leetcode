package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class l_118 {
    public static void main(String[] args) {
        List<List<Integer>> generate = generate(10);
        for (List<Integer> list : generate) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }

    public static List<List<Integer>> generate(int numRows) {

        int[][] books = new int[numRows][];
        for (int i = 0; i < books.length; i++) {
            books[i] = new int[i + 1];
        }
        for (int i = 0; i < books.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    books[i][j] = 1;
                } else {
                    books[i][j] = books[i - 1][j - 1] + books[i - 1][j];
                }
            }
        }

        ArrayList<List<Integer>> result = new ArrayList<>();
        for (int[] book : books) {
            List<Integer> list  =new ArrayList<>();
            for (int i : book) {
                list.add(i);
            }
            result.add(list);
        }
        return result;
    }
}
