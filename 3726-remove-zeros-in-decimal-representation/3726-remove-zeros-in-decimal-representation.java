class Solution {
    public long removeZeros(long n) {
      double ans =0;  
      long i=0;
        while(n>0)
            { long x= n%10;
                if(x!=0)
       {ans=ans+x*Math.pow(10,i++);}
                n=n/10;
            }
        return (long)ans;
    }
}