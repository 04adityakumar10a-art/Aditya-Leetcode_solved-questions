class Solution {
    public int[] leftRightDifference(int[] nums) {
        int leftsum[] = new int[nums.length];
        int rightsum[] = new int[nums.length];
        int sum1=0;
        int sum2=0;
        for(int i=0;i<nums.length;i++)
        {
            rightsum[i]=sum1;
            sum1+=nums[i];
            System.out.print(rightsum[i]+" ");
        }
         for(int i=nums.length-1;i>=0;i--)
        {
            leftsum[i]=sum2;
            sum2+=nums[i];
             System.out.print(leftsum[i]+" ");
          
        }
           System.out.println();

         for(int i=0;i<nums.length;i++)
        {
            nums[i]=Math.abs(leftsum[i]-rightsum[i]);
        }
        return nums;
    }
}