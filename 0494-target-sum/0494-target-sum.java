class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        
        int totalSum = 0;
        for (int num : nums)
            totalSum += num;
        
        // Edge cases
        if (Math.abs(target) > totalSum) return 0;
        if ((target + totalSum) % 2 != 0) return 0;
        
        int subsetSum = (target + totalSum) / 2;
        
        int[] dp = new int[subsetSum + 1];
        dp[0] = 1;   // One way to make sum 0
        
        for (int num : nums) {
            // Traverse backwards (0/1 knapsack)
            for (int s = subsetSum; s >= num; s--) {
                dp[s] += dp[s - num];
            }
        }
        
        return dp[subsetSum];
    }
}