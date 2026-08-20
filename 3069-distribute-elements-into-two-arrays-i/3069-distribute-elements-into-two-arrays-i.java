class Solution {
    public int[] resultArray(int[] nums) {
        ArrayList<Integer> l1 = new ArrayList<>(List.of(nums[0]));
        ArrayList<Integer> l2 = new ArrayList<>(List.of(nums[1]));
        int k=0;
        int j=0;
        for(int i=2;i<nums.length;i++)
        { if(l1.get(k)>l2.get(j)) 
            {
                l1.add(nums[i]);
                k++;
            }
            else {
                l2.add(nums[i]);
                j++;
            }
        }
        int t=0;
     for(int i=0;i<l1.size();i++)
     {
       nums[t++]=l1.get(i);
     }
     for(int i=0;i<l2.size();i++)
     {
       nums[t++]=l2.get(i);
     }

     return nums ;

    }
}