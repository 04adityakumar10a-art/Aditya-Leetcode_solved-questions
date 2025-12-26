import java.util.*;

class Solution {
    public long totalScore(int hp, int[] damage, int[] requirement) {
        int n = damage.length;

        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++)
            prefix[i + 1] = prefix[i] + damage[i];

        long ans = 0;

        for (int i = 0; i < n; i++) {
            long need = prefix[i + 1] - (hp - requirement[i]);

            // find smallest start such that prefix[start] >= need
            int start = lowerBound(prefix, need);

            if (start <= i)
                ans += (i - start + 1);
        }

        return ans;
    }

    // Standard lower_bound for prefix[]
    private int lowerBound(long[] arr, long target) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr[mid] < target)
                l = mid + 1;
            else
                r = mid;
        }
        return l;
    }
}
