class Solution {
    public static int sum(int n) 
    {   int sum =1 ;
        while(n>0)
        {
          int rem= n%10;
          sum*=rem;
          n/=10;
        }
        return sum ;
    }
    public int smallestNumber(int n, int t) {
        while(sum(n) % t != 0)
        {
            n++;
        }
        return n;
    }
}