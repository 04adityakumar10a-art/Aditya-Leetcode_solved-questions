class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        
        int[] prev = new int[m + 1];
        int ans = 0;

        for (int i = n - 1; i >= 0; i--) {
            int[] curr = new int[m + 1];
            for (int j = m - 1; j >= 0; j--) {
                if (nums1[i] == nums2[j]) {
                    curr[j]= 1 + prev[j + 1];
                    ans = Math.max(ans, curr[j]);
                }
            }
            prev =curr;
        }

        return ans;
    }
}