class Solution {
    public int search(int[] nums, int target) {
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            mp.put(nums[i],i);
        }
        if(mp.containsKey(target))
        {
            return mp.get(target);
        }
        else  return -1;
    }
}