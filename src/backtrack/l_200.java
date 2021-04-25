package backtrack;

public class l_200 {
    public static void main(String[] args) {
        char[][] grids = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        System.out.println(numIslands(grids));
    }

    public static int numIslands(char[][] grid) {
        int count = 0;
        int[][] directions = new int[][]{
                {0, 1},
                {1, 0},
                {0, -1},
                {-1, 0}
        };
        for (int i = 0; i < grid.length; i++) {
            for (int i1 = 0; i1 < grid[i].length; i1++) {
                if (grid[i][i1] == '1') {
                    count++;
                    dfs(grid, i, i1, directions);
                }
            }
        }
        return count;
    }

    private static void dfs(char[][] grid, int i, int i1, int[][] directions) {
        grid[i][i1] = '0';
        for (int[] direction : directions) {
            int x = direction[0] + i;
            int y = direction[1] + i1;
            if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == '0') {
                continue;
            }
            dfs(grid, x, y, directions);
        }
    }
}
