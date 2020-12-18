package leetcode;

public class l_221 {
    public static void main(String[] args) {
        char[][] chars = new char[][]{
                {'0', '1', '1', '1', '0'},
                {'1', '1', '1', '1', '0'},
                {'0', '1', '1', '1', '1'},
                {'0', '1', '1', '1', '1'},
                {'0', '0', '1', '1', '1'}
        };
        chars = new char[][]{
                {'0', '1'},
                {'1', '0'}
        };
        System.out.println(maximalSquare(chars));
    }


    public static int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        int[][] book = new int[matrix.length][matrix[0].length];
        int result = -1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0 || j == 0) {
                    book[i][j] = matrix[i][j] - 48;
                    result = Math.max(book[i][j], result);
                    continue;
                }
                if (matrix[i][j] == '1') {
                    book[i][j] = Math.min(book[i - 1][j], Math.min(book[i][j - 1], book[i - 1][j - 1])) + 1;
                }
                result = Math.max(result, book[i][j]);
            }
        }
        for (int i = 0; i < book.length; i++) {
            for (int i1 = 0; i1 < book[i].length; i1++) {
                System.out.print(book[i][i1] + " ");
            }
            System.out.println();
        }
        return result * result;
    }
}
