class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        for(int i = 0;i<rocks.length;i++) capacity[i]-=rocks[i];
        Arrays.sort(capacity);
        for(int i = 0;i<rocks.length;i++){
            additionalRocks-=capacity[i];
            if(additionalRocks<0) return i;
        }
        return rocks.length;
    }
}