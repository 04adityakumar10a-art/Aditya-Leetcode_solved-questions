class Solution {
    public int rob1(int[] nums) {
        int n=nums.length;
        int dp[]=new int[n+1];
        dp[0]=0;
        dp[1]=nums[0];
        for(int i =2;i<=n;i++)
        {
            int pick=nums[i-1]+dp[i-2];
            int nopick=0+dp[i-1];
            dp[i]=Math.max(pick,nopick);
        }
        return dp[n];
    }
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        int[] hwfst=new int[n-1];
        int[] hwlst=new int[n-1];
        int j=0,k=0;
        for(int i =0;i<n;i++)
        { if(i!=0) hwfst[j++]=nums[i]; }
          for(int i =0;i<n;i++)
        { if(i!=n-1) hwlst[k++]=nums[i]; }
        return Math.max(rob1(hwfst),rob1(hwlst));
    }
}