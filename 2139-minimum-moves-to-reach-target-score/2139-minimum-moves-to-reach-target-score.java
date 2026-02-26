class Solution {
    public int minMoves(int target, int maxDoubles) {
        int ans=0;
         while(maxDoubles>0 &&  target>0 )
        {
            if(target%2==0)
            {
                maxDoubles--;
                target=target/2;
                ans++;
            }
            else{
                target--;
                ans++;
            }

        }
        return ans+target-1;
    }
}