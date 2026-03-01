class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n= cost.length;
        int dp[] = new int[n+1];
        dp[1]=0;
        dp[0]=0;
        for(int i=2;i<=n;i++)
        {
            int onestep=cost[i-1]+dp[i-1];
            int twostep=cost[i-2]+dp[i-2];
            dp[i]=Math.min(onestep,twostep);
        }
        return dp[n];
    }
}