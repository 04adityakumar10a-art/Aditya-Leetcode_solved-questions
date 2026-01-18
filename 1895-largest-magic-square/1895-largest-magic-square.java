class Solution {

    int rowSum(int[][] g, int r, int c, int k) {
        int sum = 0;
        for (int j = c; j < c + k; j++) sum += g[r][j];
        return sum;
    }

    int colSum(int[][] g, int r, int c, int k) {
        int sum = 0;
        for (int i = r; i < r + k; i++) sum += g[i][c];
        return sum;
    }

    boolean checkMagic(int[][] g, int r, int c, int k) {
        int target = rowSum(g, r, c, k);

        // check rows
        for (int i = 0; i < k; i++) {
            if (rowSum(g, r + i, c, k) != target) return false;
        }

        // check columns
        for (int j = 0; j < k; j++) {
            if (colSum(g, r, c + j, k) != target) return false;
        }

        // check diagonals
        int d1 = 0, d2 = 0;
        for (int i = 0; i < k; i++) {
            d1 += g[r + i][c + i];
            d2 += g[r + i][c + k - 1 - i];
        }

        return d1 == target && d2 == target;
    }

    public int largestMagicSquare(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int maxSize = Math.min(m, n);

        for (int k = maxSize; k >= 2; k--) {
            for (int i = 0; i + k <= m; i++) {
                for (int j = 0; j + k <= n; j++) {
                    if (checkMagic(grid, i, j, k)) return k;
                }
            }
        }
        return 1;
    }
}
