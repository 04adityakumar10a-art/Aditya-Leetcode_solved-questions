class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums)
            sum += num;
        
        // If total sum is odd, cannot split equally
        if (sum % 2 != 0)
            return false;
        
        int target = sum / 2;
        
        // dp[i] = can we make sum i ?
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;   // zero sum is always possible
        
        for (int num : nums) {
            // Traverse backwards to avoid reuse
            for (int i = target; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
            }
        }
        
        return dp[target];
    }
}