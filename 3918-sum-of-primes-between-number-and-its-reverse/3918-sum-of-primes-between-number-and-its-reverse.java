class Solution {
    public boolean isprime(int n)
    {   if(n<2) return false;
        int x=(int)Math.sqrt(n);
        for(int i=2;i<=n/2;i++)
        {
            if(n%i==0) return false;
        }
        return true;
    }
    public int reverse(int n)
    {
        int ans=0;
        while(n>0)
        {
            int rem=n%10;
            ans=ans*10+rem;
            n/=10;
        }
        return ans;
    }
    public int sumOfPrimesInRange(int n) {
        int sum=0;
       int rev=reverse(n);
       for(int i=Math.min(n,rev);i<=Math.max(n,rev);i++)
       {
        if(isprime(i))    sum+=i;
       }
       return sum;
    }
}