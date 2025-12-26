import java.util.HashMap;
import java.util.Map;

class Solution {
    public int subarraySum(int[] nums, int target) {
        int count = 0, sum = 0;
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1); // Base case: prefix sum 0 appears once

        for (int num : nums) {
            sum += num;
            if (prefixSumCount.containsKey(sum - target)) {
                count += prefixSumCount.get(sum - target);
            }
            prefixSumCount.put(sum, prefixSumCount.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}