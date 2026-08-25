class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> hs = new HashSet<>();
        for(int x : nums) hs.add(x);
        int i =1 ;
        while(hs.contains(k*i)) i++;
        return k*i;
    }
}