class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        //2 serpate oops 1 for inc and 2nd for dec O(2n)
        int max1=0,max2=0,max=0;
        int prev1=0,prev2=51;
        int temp1=0,temp2=0;
        for(int i=0 ; i<nums.length ; i++)
        {  if(nums[i]>prev1) temp1++;
           else{
            max1=Math.max(max1,temp1);
            temp1=1;
           }
           prev1=nums[i];
        }
                max1 = Math.max(max1, temp1);   
        for(int i=0 ; i<nums.length ; i++)
        {  if(nums[i]<prev2) temp2++;
           else{
            max2=Math.max(max2,temp2);
            temp2=1;
           }
           prev2=nums[i];
        }
                max2 = Math.max(max2, temp2);   

        return Math.max(max1,max2);
    }
}