class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
         
         Arrays.sort(hBars);
         Arrays.sort(vBars);
         int hcount =0 , vcount=0 , longesth=0 ,longestv=0;
         for(int i =0;i<hBars.length-1;i++)
         {
            if((hBars[i]+1)==hBars[i+1]) hcount++;
            else
             { longesth=Math.max(longesth,hcount);
               hcount =0;
            }
         }longesth=Math.max(longesth,hcount);
         for(int i =0;i<vBars.length-1;i++)
         {
            if((vBars[i]+1)==vBars[i+1]) vcount++;
            else
             { longestv=Math.max(longestv,vcount);
               vcount =0;
            }
         }longestv=Math.max(longestv,vcount);
         int ans = Math.min(longesth,longestv);
         ans=ans+2;
         return ans*ans;
    }
}