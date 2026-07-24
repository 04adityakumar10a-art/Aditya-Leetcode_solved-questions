class Solution {
    public int uniqueXorTriplets(int[] nums) {

        boolean[] present = new boolean[2048];

        for (int x : nums) {
            present[x] = true;
        }

        boolean[] pairXor = new boolean[2048];

        for (int a = 0; a < 2048; a++) {
            if (!present[a]) continue;

            for (int b = 0; b < 2048; b++) {
                if (!present[b]) continue;

                pairXor[a ^ b] = true;
            }
        }

        boolean[] answer = new boolean[2048];

        for (int x = 0; x < 2048; x++) {
            if (!pairXor[x]) continue;

            for (int a = 0; a < 2048; a++) {
                if (!present[a]) continue;

                answer[x ^ a] = true;
            }
        }

        int count = 0;

        for (boolean v : answer) {
            if (v) count++;
        }

        return count;
    }
}