class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] arr = new int[128]; // ASCII
        int left = 0, maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            arr[c]++;

            // shrink window until valid
            while (arr[c] > 1) {
                arr[s.charAt(left)]--;
                left++;
            }

            // update max length
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
