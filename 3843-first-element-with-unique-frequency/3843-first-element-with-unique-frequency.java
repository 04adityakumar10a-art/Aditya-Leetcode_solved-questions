class Solution {
    public int firstUniqueFreq(int[] nums) {

        // Step 1: Count element frequencies
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Step 2: Count frequency of frequencies
        HashMap<Integer, Integer> freqCount = new HashMap<>();
        for (int f : freq.values()) {
            freqCount.put(f, freqCount.getOrDefault(f, 0) + 1);
        }

        // Step 3: Find first element whose frequency is unique
        for (int num : nums) {
            int f = freq.get(num);
            if (freqCount.get(f) == 1) {
                return num;
            }
        }

        return -1;
    }
}
