class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        //check if nums1 and 2 which is larger make hash and search 
        HashSet<Integer> mp=new HashSet<>();
        if(nums1.length>=nums2.length)
        {
            for(int i=0;i<nums1.length;i++)
            {
                mp.add(nums1[i]);
            }
             for(int i=0;i<nums2.length;i++)
            {
                if(mp.contains(nums2[i])) return nums2[i];
            }
        }
         else
        {
            for(int i=0;i<nums2.length;i++)
            {
                mp.add(nums2[i]);
            }
             for(int i=0;i<nums1.length;i++)
            {
                if(mp.contains(nums1[i])) return nums1[i];
            }
        }
        return -1;
    }
}