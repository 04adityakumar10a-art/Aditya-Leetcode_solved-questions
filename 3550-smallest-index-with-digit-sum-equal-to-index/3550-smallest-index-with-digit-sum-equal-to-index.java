class Solution {
    public int digitsum(int n )
    {
        int sum=0;
        if(n<10) return n;
        while(n>0)
        {
            sum+=n%10;
            n/=10;
        }

        return sum;
    }
    public int smallestIndex(int[] nums) {
        
        for(int i =0 ; i<nums.length;i++)
        {
            if(i==digitsum(nums[i])) return i;
        }

        return -1 ;
        
    }
}