class Solution {
     int gcd(int a, int b) {
    return (b == 0) ? a : gcd(b, a % b);
}   
    public long gcdSum(int[] nums) {
        int max=0;
        int prefix[] =new int[nums.length];
        for(int i=0; i<nums.length; i++)
        {
              if (nums[i] > max) {
                max = nums[i];
            }
          prefix[i]=gcd(nums[i],max);  
        }
        Arrays.sort(prefix);
       
        int start=0;
        int end=prefix.length-1;
        long sum=0;
        while(start<end)
        {
          sum+=gcd(prefix[start],prefix[end]);
          start++;
          end--;
        }
        return sum;
    }
}