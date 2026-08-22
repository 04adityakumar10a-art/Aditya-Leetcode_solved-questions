class Solution {
    public boolean checkDivisibility(int n) {
        int sum=0;
        int product =1;
        if (n==0) return true ;
        int ans=n;
        while(n>0)
        {
            int rem = n%10;
            sum+=rem;
            product*=rem;
            n=n/10;
        }
        return (ans % (sum+product))==0;
    }
}