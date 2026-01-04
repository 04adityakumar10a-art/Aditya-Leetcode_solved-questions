class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        Arrays.sort(capacity);
        int totalapple=0;
        int reqcapacity=0;
        for(int i=0;i<apple.length;i++)
         {totalapple+=apple[i];}
         for(int i=capacity.length-1;i>=0;i--)
         {  reqcapacity= reqcapacity+capacity[i];
            if(reqcapacity >= totalapple) return  capacity.length-i;
           
         }
         return 0;
    }
}