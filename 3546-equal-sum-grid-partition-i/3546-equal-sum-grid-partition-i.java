class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int size = m * n;

        long totalsum = 0;

        long[] prerow = new long[size + 1];
        long[] precol = new long[size + 1];

        int idx = 1;

        // row-wise flatten
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                totalsum += grid[i][j];
                prerow[idx] = prerow[idx - 1] + grid[i][j];
                idx++;
            }
        }

        idx = 1;

        // column-wise flatten
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                precol[idx] = precol[idx - 1] + grid[i][j];
                idx++;
            }
        }

        if (totalsum % 2 != 0) return false;

        long target = totalsum / 2;

        // row cuts
        for (int i = 1; i <= size; i++) {
            if (prerow[i] == target && (i % n == 0) && i != size)
                return true;
        }

        // column cuts
        for (int i = 1; i <= size; i++) {
            if (precol[i] == target && (i % m == 0) && i != size)
                return true;
        }

        return false;
    }
}