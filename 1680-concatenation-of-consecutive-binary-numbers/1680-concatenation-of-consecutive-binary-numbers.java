class Solution {
    public int concatenatedBinary(int n) {
        long MOD = 1000000007;
        long ans = 0;
        int length = 0;

        for(int i = 1; i <= n; i++) {
            
            // check if i is power of 2
            if((i & (i - 1)) == 0) {
                length++;   // increase bit length
            }
            
            ans = ((ans << length) % MOD + i) % MOD;
        }

        return (int) ans;
    }
}