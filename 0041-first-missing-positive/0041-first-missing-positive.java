
class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // Place each number x in its correct position if 1 <= x <= n
        for (int i = 0; i < n; i++) {
            while (nums[i] >= 1 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int correctIndex = nums[i] - 1;

                // swap nums[i] with nums[correctIndex]
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            }
        }

        // After placement, the first index i where nums[i] != i+1 is the answer
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        // If all positions are correct, answer is n+1
        return n + 1;
    }
}

