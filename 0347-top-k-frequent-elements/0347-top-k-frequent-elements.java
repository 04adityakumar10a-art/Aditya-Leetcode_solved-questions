class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // Step 1: Count frequencies
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Step 2: Min heap by frequency
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[1] - b[1]   // compare by frequency
        );

        // Step 3: Keep only top k elements in heap
        for (int key : map.keySet()) {
            pq.add(new int[]{key, map.get(key)});
            if (pq.size() > k) {
                pq.poll();
            }
        }

        // Step 4: Extract result
        int[] ans = new int[k];
        int i = 0;
        while (!pq.isEmpty()) {
            ans[i++] = pq.poll()[0];
        }

        return ans;
    }
}
