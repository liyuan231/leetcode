package backtrack;

public class l_79 {

    public static void main(String[] args) {
        char[][] chars = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "SEE";
        System.out.println(exist(chars, word));
    }

    public static boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        int[][] directions = new int[][]{
                {0, 1},
                {0, -1},
                {1, 0},
                {-1, 0}
        };
        for (int i = 0; i < board.length; i++) {
            for (int i1 = 0; i1 < board[i].length; i1++) {
                if (dfs(i, i1, 0, board, word.toCharArray(), visited,directions)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(int x, int y, int curIndex, char[][] board, char[] word, boolean[][] visited, int[][] directions) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || visited[x][y]) {
            return false;
        }
        if (curIndex == word.length - 1) {
            return board[x][y] == word[curIndex];
        }
        if (board[x][y] == word[curIndex]) {
            visited[x][y] = true;
            for (int[] direction : directions) {
                if(dfs(x + direction[0], y+direction[1], curIndex + 1, board, word, visited, directions)){
                    return true;
                }
            }
            visited[x][y] = false;
        }
        return false;
    }
}
