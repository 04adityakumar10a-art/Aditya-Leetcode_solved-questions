class Solution {
    public long[] distance(int[] nums) {
        HashMap<Integer, ArrayList<Integer>> mp = new HashMap<>();
        
        // Step 1: store indices
        for (int i = 0; i < nums.length; i++) {
            mp.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        long[] res = new long[nums.length];

        // Step 2: process each group
        for (ArrayList<Integer> list : mp.values()) {
            int n = list.size();
            long[] prefix = new long[n];

            // build prefix sum
            prefix[0] = list.get(0);
            for (int i = 1; i < n; i++) {
                prefix[i] = prefix[i - 1] + list.get(i);
            }

            for (int i = 0; i < n; i++) {
                int idx = list.get(i);

                // left side
                long left = (long) idx * i - (i > 0 ? prefix[i - 1] : 0);

                // right side
                long right = (prefix[n - 1] - prefix[i]) - (long) idx * (n - i - 1);

                res[idx] = left + right;
            }
        }

        return res;
    }
}