class Solution {
    public int minimumPrefixLength(int[] nums) {
        int pause=0;
        for(int i=0 ; i<nums.length-1 ; i++)
        {
            if(nums[i]>=nums[i+1] ) pause=i+1;
        }
        return pause;
    }
}