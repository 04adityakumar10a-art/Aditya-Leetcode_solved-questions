class Solution {
    public int sumFourDivisors(int[] nums) {
        int totalsum=0;
        for(int i=0 ;i<nums.length ; i++)
    {    int count=0;
         int sum = nums[i]+1;
        for(int j = 2 ; j<nums[i] ; j++)
        {
          if(nums[i]%j ==0)
          { count++;
          sum=sum+j;
          if(count >4 ) break;
          }
        }
        if(count==2) totalsum+=sum;
    }
    return totalsum;
    }
}