class Solution {

    public int[] gcdValues(int[] nums, long[] queries) {

        int mx = 0;
        for (int x : nums) mx = Math.max(mx, x);

        int[] freq = new int[mx + 1];

        for (int x : nums) {
            freq[x]++;
        }

        long[] divCnt = new long[mx + 1];

        for (int g = 1; g <= mx; g++) {
            for (int multiple = g; multiple <= mx; multiple += g) {
                divCnt[g] += freq[multiple];
            }
        }

        long[] gcdPairs = new long[mx + 1];

        for (int g = mx; g >= 1; g--) {

            gcdPairs[g] = divCnt[g] * (divCnt[g] - 1) / 2;

            for (int multiple = 2 * g; multiple <= mx; multiple += g) {
                gcdPairs[g] -= gcdPairs[multiple];
            }
        }

        long[] prefix = new long[mx + 1];

        for (int g = 1; g <= mx; g++) {
            prefix[g] = prefix[g - 1] + gcdPairs[g];
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            ans[i] = lowerBound(prefix, queries[i]);
        }

        return ans;
    }

    private int lowerBound(long[] prefix, long q) {

        int l = 1;
        int r = prefix.length - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (prefix[mid] > q) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }
}
