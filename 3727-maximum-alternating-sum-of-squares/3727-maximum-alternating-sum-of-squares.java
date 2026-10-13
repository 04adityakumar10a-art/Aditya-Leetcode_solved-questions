class Solution {
    public long maxAlternatingSum(int[] nums) {
        long ans=0;
        if(nums.length==1) return nums[0]*nums[0];
        for(int i=0; i< nums.length ; i++ )
        {
            nums[i]= Math.abs(nums[i]);
        }
        Arrays.sort(nums);
        int end=0;
        int start=0;
        if(nums.length%2==0)
             end=nums.length-1;
        else {
           end=nums.length-2; 
           ans+=Math.pow(nums[nums.length-1],2);
        }
        while(start<end)
        {
            ans+=(nums[end]*nums[end]) - (nums[start]*nums[start]);
            start++; end--;
        }

        return ans;
  
    }
}