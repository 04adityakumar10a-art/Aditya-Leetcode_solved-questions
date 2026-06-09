class Solution {
    public long maxTotalValue(int[] nums, int k) {
       Arrays.sort(nums);
       long ans=k*(nums[nums.length-1]-nums[0]);
      return 1L * k * (nums[nums.length - 1] - nums[0]);
    }
}