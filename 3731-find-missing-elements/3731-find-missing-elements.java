class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);
        ArrayList<Integer> ls = new ArrayList<>();
        HashSet<Integer> st = new HashSet<>();
        for(int i=0;i<nums.length;i++) st.add(nums[i]);
        for(int i=nums[0]; i<nums[nums.length-1] ; i++ )
        {
            if(!st.contains(i)) ls.add(i);
        }
        return ls;
    }
}