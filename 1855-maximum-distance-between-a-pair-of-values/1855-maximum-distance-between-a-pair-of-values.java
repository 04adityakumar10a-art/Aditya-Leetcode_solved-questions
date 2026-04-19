class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int ans = 0;
        int n = nums2.length;

        for (int i = 0; i < nums1.length; i++) {
            int left = i, right = n - 1;
            int best = i - 1; // if no valid j

            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (nums2[mid] >= nums1[i]) {
                    best = mid;      // valid j
                    left = mid + 1; // try farther
                } else {
                    right = mid - 1;
                }
            }

            ans = Math.max(ans, best - i);
        }

        return ans;
    }
}