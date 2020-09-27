package leetcode;

/**
 * [[0,0,0,0,0,0,0,0,0],
 * [0,0,0,0,0,0,0,0,0],
 * [0,0,0,0,0,0,0,0,0],
 * [0,0,0,0,1,0,0,0,0],
 * [0,0,0,0,0,0,0,0,0],
 * [0,0,0,0,1,0,0,0,0],
 * [0,0,0,0,0,0,1,0,0],
 * [0,1,0,0,0,0,0,0,0]]
 */
public class l_5511 {
    public static void main(String[] args) {
        int[][] nums = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 1, 0, 0, 0, 0, 0, 0, 0}

        };
        nums = new int[][]{
                {1,0,0},
                {0,0,1},
                {1,0,0}
        };
        System.out.println(numSpecial(nums));

    }

    public static int numSpecial(int[][] mat) {
        if (mat.length == 0) {
            return 0;
        }
//        boolean[][] book = new boolean[mat.length][];
        boolean[] rows = new boolean[mat.length];
        boolean[] columns = new boolean[mat[0].length];
        int count = 0;
        for (int i = 0; i < mat.length; i++) {
            if (rows[i]) {
                continue;
            }
            for (int j = 0; j < mat[i].length; j++) {
                if (columns[j]) {
                    continue;
                }
                if (mat[i][j] == 1) {
                    boolean validRow = searchRow(mat, i, j);
                    if (!validRow) {
                        rows[i] = true;
                    }
                    boolean validColumn = searchColumn(mat, i, j);
                    if (!validColumn) {
                        columns[j] = true;
                    }
                    if (validColumn && validRow) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private static boolean searchColumn(int[][] mat, int i, int j) {
        for (int k = 0; k < mat.length; k++) {
            if (k == i) {
                continue;
            }
            if (mat[k][j] == 1) {
                return false;
            }
        }
        return true;
    }

    private static boolean searchRow(int[][] mat, int i, int j) {
        for (int k = 0; k < mat[i].length; k++) {
            if (k == j) {
                continue;
            }
            if (mat[i][k] == 1) {
                return false;
            }
        }
        return true;
    }
}
