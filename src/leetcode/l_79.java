package leetcode;

/**
 * TODO 未完成
 */
public class l_79 {
    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println(exist(board, "ABCCE"));
    }

    public static boolean exist(char[][] board, String word) {
        int rows = board.length;
        if (rows == 0) {
            return false;
        }
        int columns = board[0].length;
        boolean[][] marks = new boolean[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (backtrack(i, j, word,0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean backtrack(int i, int j,String word, int start) {
        if(start == word.length()-1){

        }
        return false;
    }
}
