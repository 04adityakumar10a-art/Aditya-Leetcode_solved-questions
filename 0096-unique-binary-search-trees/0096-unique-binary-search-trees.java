class Solution {
    int[] dp;

    public int numTrees(int n) {
        dp = new int[n + 1];
        return recur(n);
    }

    public int recur(int n) {
        if (n <= 1) return 1;

        if (dp[n] != 0) return dp[n];

        int ans = 0;

        for (int i = 1; i <= n; i++) {
            int left = recur(i - 1);
            int right = recur(n - i);

            ans += left * right;
        }

        return dp[n] = ans;
    }
}