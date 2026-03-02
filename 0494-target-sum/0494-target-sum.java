class Solution {

    Integer[][] dp;
    int totalSum;

    public int findTargetSumWays(int[] nums, int target) {

        totalSum = 0;
        for (int num : nums)
            totalSum += num;

        if (Math.abs(target) > totalSum)
            return 0;

        dp = new Integer[nums.length][2 * totalSum + 1];

        return rec(nums, target, nums.length - 1);
    }

    public int rec(int[] nums, int target, int index) {

        // prune impossible targets
        if (Math.abs(target) > totalSum)
            return 0;

        if (index < 0)
            return target == 0 ? 1 : 0;

        if (dp[index][target + totalSum] != null)
            return dp[index][target + totalSum];

        int plus = rec(nums, target - nums[index], index - 1);
        int minus = rec(nums, target + nums[index], index - 1);

        return dp[index][target + totalSum] = plus + minus;
    }
}