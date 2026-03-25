class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int size = m*n;
        //total sum
        long totalsum=0;
        //prefisum rows
        long[] prerow=new long[size+1];
        //prefixsum cols
        long[] precol=new long[size+1];
        //individually traverse both
       
        int idx=1; 
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {  totalsum+=grid[i][j];
               prerow[idx]=prerow[idx-1]+grid[i][j];
               idx++;
            }
        }
        idx=1;
      for(int j=0;j<n;j++)
        {
            for(int i=0;i<m;i++)
            { 
               precol[idx]=precol[idx-1]+grid[i][j];
               idx++;
            }
        } 
        if(totalsum%2!=0) return false;
        //if total= totalsum/2 and (index+1)% rows == 0
        for(int i=1;i<size+1;i++)
        {
            if((prerow[i]==totalsum/2) && (i%n==0) && i != size) return true;
            
        }
        //if total= totalsum/2 and (index+1)% cols == 0
        for(int i=1;i<size+1;i++)
        {
            if((precol[i]==totalsum/2) && (i%m==0) && i != size) return true;
            
        }
        // else false;
        return false;
    }
}