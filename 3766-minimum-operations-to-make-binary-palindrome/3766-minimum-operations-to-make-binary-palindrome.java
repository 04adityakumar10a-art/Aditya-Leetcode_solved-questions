class Solution {

    // Check if a number's binary representation is a palindrome
    private boolean isBinaryPalindrome(int num) {
        String s = Integer.toBinaryString(num);
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }

    // Find minimum +/- operations to reach nearest binary palindrome
    private int nearestPalindromeSteps(int num) {
        if (isBinaryPalindrome(num)) return 0;

        int steps = 1;

        while (true) {
            // check num - steps (if valid)
            if (num - steps >= 0 && isBinaryPalindrome(num - steps))
                return steps;

            // check num + steps
            if (isBinaryPalindrome(num + steps))
                return steps;

            steps++;
        }
    }

    public int[] minOperations(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = nearestPalindromeSteps(nums[i]);
        }
        return ans;
    }
}
