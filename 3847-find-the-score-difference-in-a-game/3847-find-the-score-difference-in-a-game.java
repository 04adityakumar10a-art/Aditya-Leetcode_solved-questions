class Solution {
    public int scoreDifference(int[] nums) {
        int runner =1;
        int sum=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]%2 !=0) runner=runner*-1;
            if((i+1)%6==0) runner=runner*-1;
            sum=sum+nums[i]*runner;
        }
        return sum;
    }
}