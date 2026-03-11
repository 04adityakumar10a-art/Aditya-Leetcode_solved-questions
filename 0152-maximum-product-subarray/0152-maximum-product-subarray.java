class Solution {
    public int maxProduct(int[] nums) {

        int maxProd = nums[0];
        int minProd = nums[0];
        int ans = nums[0];

        for (int i = 1; i < nums.length; i++) {

            int x = nums[i];

            int tempMax = Math.max(x, Math.max(x * maxProd, x * minProd));
            int tempMin = Math.min(x, Math.min(x * maxProd, x * minProd));

            maxProd = tempMax;
            minProd = tempMin;

            ans = Math.max(ans, maxProd);
        }

        return ans;
    }
}