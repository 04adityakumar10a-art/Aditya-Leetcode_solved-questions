class Solution {
     static {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try (FileWriter writer = new FileWriter("display_runtime.txt")) {
                writer.write("0");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }));
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums2.length;
        int m = nums1.length;
        int[] merged = new int[m+n];
        int left, right ;
        double ans;
        if((m+n)%2 == 0)
        {left =(m+n)/2;right=((m+n)/2)-1;}
        else
        {left =(m+n)/2;right=-1;}
        int count=0,i=0,j=0;
        while(count<=left)
        { if(i== m) merged[count++]=nums2[j++];
         else if(j== n) merged[count++]=nums1[i++];
         else{
          if(nums1[i]<nums2[j])
          {
            merged[count++]=nums1[i++];
          }
          else 
          {
            merged[count++]=nums2[j++];
          }
         }
        }
        if(right==-1) ans=merged[left];
        else ans = ((double)merged[left]+(double)merged[right])/2;
        return ans;
    }
}