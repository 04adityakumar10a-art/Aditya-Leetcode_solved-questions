class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] ans = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int idx = i * m + j;
                int newIdx = (idx + k) % (n * m);

                int r = newIdx / m;
                int c = newIdx % m;

                ans[r][c] = grid[i][j];
            }
        }

        List<List<Integer>> result = new ArrayList<>();

        for (int[] row : ans) {
            List<Integer> temp = new ArrayList<>();
            for (int val : row) {
                temp.add(val);
            }
            result.add(temp);
        }

        return result;
    }
}