class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2,
                                 int k1, int k2) {
        int n = nums1.length;
        long k = (long) k1 + k2;

        long[] diff = new long[n];
        long total = 0;
        long maxDiff = 0;

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs((long) nums1[i] - nums2[i]);
            total += diff[i];
            maxDiff = Math.max(maxDiff, diff[i]);
        }

        if (total <= k) return 0;

        // Binary search for the minimum achievable maximum difference
        long low = 0, high = maxDiff;

        while (low < high) {
            long mid = low + (high - low) / 2;
            long needed = 0;

            for (long d : diff) {
                if (d > mid) {
                    needed += d - mid;
                }
            }

            if (needed <= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        long level = low;
        long used = 0;
        long ans = 0;
        long count = 0;

        for (long d : diff) {
            if (d > level) {
                used += d - level;
            }

            long value = Math.min(d, level);
            ans += value * value;

            if (d >= level && level > 0) {
                count++;
            }
        }

        // Use remaining operations to reduce some values
        // from level to level - 1
        long rem = k - used;
        ans -= rem * (2 * level - 1);

        return ans;
    }
}