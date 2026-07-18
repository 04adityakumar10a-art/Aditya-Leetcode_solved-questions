class Solution {
      int gcd(int a, int b) {
    return (b == 0) ? a : gcd(b, a % b);}
    public int findGCD(int[] nums) {
        int min= Integer.MAX_VALUE;
        int max= Integer.MIN_VALUE;

        for(int i =0 ;i<nums.length; i++)
        {
            max= Math.max(nums[i],max);
            min= Math.min(nums[i],min);
        }
        return gcd(max,min);
    }
}