class Solution {
    public int reverse(int a) {
        int ans = 0;
        while (a != 0) {
            int rem = a % 10;
            ans = ans * 10 + rem;
            a /= 10;
        }
        return ans;
    }

    public int minMirrorPairDistance(int[] nums) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {

            // if current number already exists as reversed of previous
            if (mp.containsKey(nums[i])) {
                min = Math.min(min, i - mp.get(nums[i]));
            }

            // store reversed version
            int rev = reverse(nums[i]);
            mp.put(rev, i);
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
}