class Solution {
    public int bitwiseComplement(int num) {if(num==0) return 1;
                                           if(num==1) return 0;
        int ans=0;
        int  idx=0;
        while(num>0)
            {
              int  rem=num%2;
                if(rem!=1)
                {ans=ans+(int)Math.pow(2,idx);}
                idx++;
                num/=2;
            }
        return ans;
    }
}