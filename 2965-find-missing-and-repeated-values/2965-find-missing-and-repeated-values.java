class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n=grid.length;
        int find[]=new int[n*n];
        for(int i=0;i<n;i++)
        {for(int j=0;j<n;j++)
        {
          find[grid[i][j]-1]++;
        }
        }
       int arr[]= new int[2];
        int idx=0;
     for(int i=0; i<find.length;i++)
     { 
        if( find[i]>1 )
        arr[idx++]=i+1;
                        }
      for(int i=0; i<find.length;i++)
     { 
        if(  find[i]==0)
        arr[idx]=i+1;
                        }
    return arr;}
    

}