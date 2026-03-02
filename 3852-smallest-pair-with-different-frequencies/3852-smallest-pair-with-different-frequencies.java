class Solution {
    public int[] minDistinctFreqPair(int[] nums) {
        int n=nums.length;
        if(n<=2) return new int[] { -1, -1 };
        int[] countarr =new int[101];
        int[] ans=new int[2];
        for(int i=0;i<n;i++)
        {
            countarr[nums[i]]++;
        }
        boolean flag=false;
        int firstcount=0;
        for(int i=1;i<101;i++)
        {
            if(countarr[i]!=0 && !flag) //first element not found
             {  firstcount=countarr[i];
                ans[0]=i;
                flag=true;
            }
            else if(countarr[i]!=0 && countarr[i]!=firstcount)
            {
                ans[1]=i;
                break;
            }
        }
        if(ans[1]==0) return new int[] { -1, -1 };
        else return ans;
    }
}