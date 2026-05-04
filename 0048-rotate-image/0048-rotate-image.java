class Solution {
    public void rotate(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        //take transpose
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            { if(i<j && i!=j)
            {
                int temp=mat[i][j];
                mat[i][j]=mat[j][i];
                mat[j][i]=temp;
            }
            }
        }
        //reverse each row 
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m/2;j++)
            {//swap 
               int temp=mat[i][j];
               mat[i][j]=mat[i][m-j-1];
               mat[i][m-j-1]=temp;
            }
        }
    }
}