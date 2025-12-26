class Solution {
    public int[] productExceptSelf(int[] nums) {
     int n=nums.length;
     int answer[]=new int[n];
    int product=1;
    if(n<2) return nums;
    int zerocount=0;
    for(int i=0;i<n;i++)
        {
      if(nums[i]!=0)
      {product=product*nums[i];
       }
         else
             zerocount++;
        }
        for(int i=0;i<n;i++)
        { int x= product;
    if(zerocount==n||zerocount>=2  )answer[i]=0;
         else
         {
         if(nums[i]!=0)
         { if(zerocount>0)
             answer[i]=0;
         else
             answer[i]=x/nums[i];}
         else
             answer[i]=product;}
        }
        return answer;
    }
}