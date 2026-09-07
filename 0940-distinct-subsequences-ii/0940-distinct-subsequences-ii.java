class Solution {
    public int distinctSubseqII(String s) {

        final long MOD = 1000000007;
        
        long[] last = new long[26];

        // Empty subsequence
        long total = 1;

        for (char c : s.toCharArray()) {

            int idx = c - 'a';

            long newTotal = (2 * total - last[idx] + MOD) % MOD;

            last[idx] = total;

            total = newTotal;
        }

        // Remove empty subsequence
        return (int)((total - 1 + MOD) % MOD);
    }
}