class Solution {
    private int digitsum(int n)
    {
        int sum=0;
        while(n>0)
        {
            int rem=n%10;
            sum+=rem;
            n/=10;
        }
        return sum;
    }
    public int minElement(int[] nums) {
        int max=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++)
        {
          if(digitsum(nums[i])<max)
        {
            max=digitsum(nums[i]);
        }
        }
        return max;
    }
}