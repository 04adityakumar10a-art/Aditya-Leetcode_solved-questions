class Solution {
    public int sortPermutation(int[] nums) {
        int n= nums.length;
        ArrayList<Integer> ls = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            if(nums[i]!=i) ls.add(nums[i]);
        }
        if(ls.size()==0) return 0 ;
        int ans= ls.get(0);
        for(int i=1; i<ls.size();i++)
        {
          ans = ans & ls.get(i);
        }
        return ans;
    }
}