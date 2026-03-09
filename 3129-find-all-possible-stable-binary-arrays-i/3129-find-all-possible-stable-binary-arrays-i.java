class Solution {
    int MOD = 1000000007;
    Integer[][][][] dp;
    int limit;

    public int numberOfStableArrays(int zero, int one, int limit) {
        this.limit = limit;
        dp = new Integer[zero + 1][one + 1][3][limit + 1];
        return solve(zero, one, 2, 0);
    }

     public int solve(int zero, int one, int last, int count) {

        if (zero == 0 && one == 0) return 1;

        if (dp[zero][one][last][count] != null)
            return dp[zero][one][last][count];

        long ans = 0;

        // place 0
        if (zero > 0) {
            if (last != 0)
                ans += solve(zero - 1, one, 0, 1);
            else if (count < limit)
                ans += solve(zero - 1, one, 0, count + 1);
        }

        // place 1
        if (one > 0) {
            if (last != 1)
                ans += solve(zero, one - 1, 1, 1);
            else if (count < limit)
                ans += solve(zero, one - 1, 1, count + 1);
        }

        return dp[zero][one][last][count] = (int)(ans % MOD);
    }
}