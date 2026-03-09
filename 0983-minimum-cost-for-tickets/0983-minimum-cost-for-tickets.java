class Solution {
    Integer[] dp;

    public int mincostTickets(int[] days, int[] costs) {
        dp = new Integer[days.length];
        return dfs(0, days, costs);
    }

    int dfs(int i, int[] days, int[] costs) {
        if (i >= days.length) return 0;
        if (dp[i] != null) return dp[i];

        int d1 = days[i] + 1;
        int d7 = days[i] + 7;
        int d30 = days[i] + 30;

        int j = i;

        while (j < days.length && days[j] < d1) j++;
        int cost1 = costs[0] + dfs(j, days, costs);

        j = i;
        while (j < days.length && days[j] < d7) j++;
        int cost7 = costs[1] + dfs(j, days, costs);

        j = i;
        while (j < days.length && days[j] < d30) j++;
        int cost30 = costs[2] + dfs(j, days, costs);

        return dp[i] = Math.min(cost1, Math.min(cost7, cost30));
    }
}