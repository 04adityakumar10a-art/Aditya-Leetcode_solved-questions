class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length, n = mat[0].length;

        // 2D prefix sum
        int[][] pref = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                pref[i][j] = mat[i - 1][j - 1]
                           + pref[i - 1][j]
                           + pref[i][j - 1]
                           - pref[i - 1][j - 1];
            }
        }

        int ans = 0;

        // Try each possible square size
        for (int k = 1; k <= Math.min(m, n); k++) {
            boolean found = false;

            for (int i = k; i <= m; i++) {
                for (int j = k; j <= n; j++) {
                    int sum = pref[i][j]
                            - pref[i - k][j]
                            - pref[i][j - k]
                            + pref[i - k][j - k];

                    if (sum <= threshold) {
                        found = true;
                        break;
                    }
                }
                if (found) break;
            }

            if (found) ans = k;
            else break; // no larger k possible
        }

        return ans;
    }
}
