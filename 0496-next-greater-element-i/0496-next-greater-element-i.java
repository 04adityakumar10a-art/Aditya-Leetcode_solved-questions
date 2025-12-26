class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
      Stack<Integer> st= new Stack<>();
     HashMap<Integer,Integer> mp= new HashMap<>();
     int ans[]= new int[nums1.length];

     for(int j=0; j<nums2.length;j++)
     {
        mp.put(nums2[j],j);
     }
      for(int i=0; i<nums1.length;i++)
     { boolean flag= false;
        for(int j=mp.get(nums1[i])+1;j<nums2.length;j++)
          {
            if(nums1[i] < nums2[j])
             {flag =true;
             ans[i]=nums2[j];break;}
          }
          if(!flag) ans[i]=-1;
     }
     return ans;
     
    }
}