class Solution {
    public int countPartitions(int[] nums) {
        int total_sum = 0;
        for (int num : nums) {
            total_sum += num;
        }

        return (total_sum % 2 == 0) ? nums.length - 1 : 0;
    }
}