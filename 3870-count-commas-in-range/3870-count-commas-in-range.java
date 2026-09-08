class Solution {
    public int countCommas(int n) {
        int count =0;
        // while(n>=1000)
        // {
        //     count++;
        //     n--;
        // }
        if(n-1000 >= 0)
        {
            return n+1-1000;
        }
       else return 0 ;
    }
}