class Solution {
  public int maxSumDivThree(int[] nums) {
    int[] dp = new int[]{0, Integer.MIN_VALUE, Integer.MIN_VALUE};
    for (int x : nums) {
        int mod = x % 3;
        int[] next = dp.clone();
        for (int r = 0; r < 3; r++) {
            if (dp[r] >= 0) {
                int newRem = (r + mod) % 3;
                next[newRem] = Math.max(next[newRem], dp[r] + x);
            }
        }
        dp = next;
    }
    return dp[0];
}

}