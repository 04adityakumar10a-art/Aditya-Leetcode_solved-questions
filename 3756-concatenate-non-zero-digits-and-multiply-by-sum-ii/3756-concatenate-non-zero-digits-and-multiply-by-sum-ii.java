class Solution {

    static final int MOD = 1_000_000_007;

    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();

        long[] value = new long[n + 1];
        int[] count = new int[n + 1];
        int[] digitSum = new int[n + 1];

        long[] pow10 = new long[n + 1];
        long[] invPow10 = new long[n + 1];

        pow10[0] = 1;
        for (int i = 1; i <= n; i++) {
            pow10[i] = (pow10[i - 1] * 10) % MOD;
        }

        long inv10 = modPow(10, MOD - 2);

        invPow10[0] = 1;
        for (int i = 1; i <= n; i++) {
            invPow10[i] = (invPow10[i - 1] * inv10) % MOD;
        }

        for (int i = 0; i < n; i++) {
            int d = s.charAt(i) - '0';

            digitSum[i + 1] = digitSum[i] + d;

            if (d == 0) {
                value[i + 1] = value[i];
                count[i + 1] = count[i];
            } else {
                value[i + 1] = (value[i] * 10 + d) % MOD;
                count[i + 1] = count[i] + 1;
            }
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int l = queries[i][0];
            int r = queries[i][1];

            int sum = digitSum[r + 1] - digitSum[l];

            int nonZero = count[r + 1] - count[l];

            long x = (value[r + 1]
                    - value[l] * pow10[nonZero] % MOD
                    + MOD) % MOD;

            ans[i] = (int) (x * sum % MOD);
        }

        return ans;
    }

    private long modPow(long a, long b) {
        long res = 1;

        while (b > 0) {
            if ((b & 1) == 1)
                res = res * a % MOD;

            a = a * a % MOD;
            b >>= 1;
        }

        return res;
    }
}