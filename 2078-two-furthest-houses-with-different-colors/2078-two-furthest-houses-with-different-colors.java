class Solution {
    public int maxDistance(int[] colors) {
        // lets try 2 pointer ;
        int max=Integer.MIN_VALUE;
       for(int i=0; i<colors.length;i++)
       { 
        for(int j=colors.length-1;j>=0;j--)
        {
            if(colors[i]!=colors[j])
            {
              max=Math.max(max,Math.abs(i-j));
            }
        }
        }
        return max;
    }
}