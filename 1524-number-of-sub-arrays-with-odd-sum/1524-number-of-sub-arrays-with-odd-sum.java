class Solution {
    public int numOfSubarrays(int[] arr) {
        long evenCount = 1; // empty prefix
        long oddCount = 0;
        long prefixSum = 0;
        long ans = 0;
        int mod = 1000000007;

        for (int num : arr) {
            prefixSum += num;

            if (prefixSum % 2 == 0) {
                ans = (ans + oddCount) % mod;
                evenCount++;
            } else {
                ans = (ans + evenCount) % mod;
                oddCount++;
            }
        }

        return (int) ans;
    }
}