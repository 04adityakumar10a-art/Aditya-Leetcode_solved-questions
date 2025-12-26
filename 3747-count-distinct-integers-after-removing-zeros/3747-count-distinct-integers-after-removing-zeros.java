class Solution {
    public long countDistinct(long n) {
        
        String s = Long.toString(n);
        int m = s.length();
        long ans = 0;

        long[] pow = new long[m+1];
        pow[0] = 1;

        for(int i = 1; i <= m ; i++)
        {
            pow[i] = pow[i-1]*9;
        }

        for(int i = 1 ; i < m ; i++)
        {
            ans += pow[i];
        }

        int j = 0;

        for(char c : s.toCharArray())
        {
            if(c == '0')break;
            long dig = c-'0';
            ans += (dig-1)*pow[m-j-1]*1L;
            j++;
        }
        
        return ans += (j == m ? 1 : 0);
    }
}