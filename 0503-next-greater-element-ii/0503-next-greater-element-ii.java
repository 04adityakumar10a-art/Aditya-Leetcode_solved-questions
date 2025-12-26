class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st= new Stack<>();
        int a= nums.length;
        int[] ans= new int[a];
        int l=a-1;
        int t;
        for(int i=l;i>=0;i--)
        {st.push(nums[i]);}
        while(l>=0)
        { if(st.isEmpty()) t=-1;
          else 
          {while(!st.isEmpty() &&st.peek()<=nums[l] )
            {
                 st.pop();
            } 
            if(st.isEmpty()) t=-1;
          else
            t=st.peek();}
          ans[l]=t;
        
          st.push(nums[l]); l--;
         
        }
    return ans;
    }

}