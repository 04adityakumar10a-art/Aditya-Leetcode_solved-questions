class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        long total = 0;
        for (int[] row : grid)
            for (int x : row)
                total += x;

        return check(grid, total) ||
               check(reverse(grid), total) ||
               check(transpose(grid), total) ||
               check(reverse(transpose(grid)), total);
    }

    private boolean check(int[][] grid, long total) {
        int m = grid.length, n = grid[0].length;
        long topSum = 0;

        for (int i = 0; i < m - 1; i++) { // cut must leave bottom non-empty
            for (int j = 0; j < n; j++) {
                topSum += grid[i][j];
            }

            long bottomSum = total - topSum;
            long diff = topSum - bottomSum;

            // ✅ Case 1: equal
            if (diff == 0) return true;

            // ✅ Case 2: remove from TOP
            if (diff > 0) {
                if (canRemove(grid, 0, i, 0, n - 1, diff))
                    return true;
            }
            // ✅ Case 3: remove from BOTTOM
            else {
                if (canRemove(grid, i + 1, m - 1, 0, n - 1, -diff))
                    return true;
            }
        }
        return false;
    }

  private boolean canRemove(int[][] grid, int r1, int r2, int c1, int c2, long val) {
    int rows = r2 - r1 + 1;
    int cols = c2 - c1 + 1;

    // ❗ If val is too large, impossible (since one cell max)
    if (val > 100000) return false; // optional optimization

    // Case 1: multi-row & multi-col
    if (rows > 1 && cols > 1) {
        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                if (grid[i][j] == val) return true;
            }
        }
    }

    // Case 2: single row
    else if (rows == 1) {
        if (grid[r1][c1] == val) return true;
        if (grid[r1][c2] == val) return true;
    }

    // Case 3: single column
    else {
        if (grid[r1][c1] == val) return true;
        if (grid[r2][c1] == val) return true;
    }

    return false;
}

    private int[][] transpose(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] res = new int[n][m];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                res[j][i] = grid[i][j];
        return res;
    }

    private int[][] reverse(int[][] grid) {
        int m = grid.length;
        int[][] res = new int[m][];
        for (int i = 0; i < m; i++)
            res[i] = grid[m - 1 - i];
        return res;
    }
}