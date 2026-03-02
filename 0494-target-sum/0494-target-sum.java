class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return rec(nums, target, nums.length - 1);
    }

    public int rec(int[] nums, int target, int index) {

        // Base case: no elements left
        if (index < 0) {
            return target == 0 ? 1 : 0;
        }

        int plus = rec(nums, target - nums[index], index - 1);
        int minus = rec(nums, target + nums[index], index - 1);

        return plus + minus;
    }
}