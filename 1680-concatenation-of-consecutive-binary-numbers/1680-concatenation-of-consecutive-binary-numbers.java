class Solution {
    public int concatenatedBinary(int n) {
        final long MOD = 1000000007;
        
        // Step 1: Build concatenated binary string
        StringBuilder sb = new StringBuilder();
        
        for(int i = 1; i <= n; i++) {
            sb.append(Integer.toBinaryString(i));
        }
        
        // Step 2: Convert binary string to decimal with modulo
        long ans = 0;
        String s = sb.toString();
        
        for(int i = 0; i < s.length(); i++) {
            ans = (ans * 2 + (s.charAt(i) - '0')) % MOD;
        }
        
        return (int) ans;
    }
}