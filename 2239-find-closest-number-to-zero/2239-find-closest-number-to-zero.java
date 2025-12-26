class Solution {
    public int findClosestNumber(int[] nums) {
        int max=Integer.MAX_VALUE;
        int dif = 0;
        int ans=0;
        
        for(int i = 0 ; i < nums.length ; i++){
            if(max>=Math.abs(nums[i]))
              {  max = Math.abs(nums[i]);
                ans=nums[i];
              }
        }
        
     if (ans < 0 && contains(nums, Math.abs(ans))) {
	            return Math.abs(ans);
	        } else {
	            return ans;
	        }
	    }
	    private boolean contains(int[] nums, int value) {
	        for (int num : nums) {
	            if (num == value) {
	                return true;
	            }
	        }
	        return false;
	    }
}