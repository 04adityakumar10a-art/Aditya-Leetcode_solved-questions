class Solution {
    static boolean rotateMatrix(int[][] mat,int target[][]) {
        int n = mat.length;
        
        // Reverse each row
        for (int i = 0; i < n; i++) {
            int start = 0, end = n - 1;
            while (start < end) {
                int temp = mat[i][start];
                mat[i][start] = mat[i][end];
                mat[i][end] = temp;
                start++;
                end--;
            }
        }

        // Performing Transpose
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
  for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(mat[i][j]!=target[i][j])
                return false;
            }
        }
        return true;
    }
    public boolean findRotation(int[][] mat, int[][] target) {
        int m,n,ones1=0,ones2=0;
        n=mat.length;
        m=mat[0].length;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(mat[i][j]==1) ones1++;
                if(target[i][j]==1) ones2++;
            }
        }
        if(ones1!=ones2) return false;
        boolean flag=false;
         for(int i=0;i<2*n;i++)
         {
           if(rotateMatrix(mat,target)) return true;
         }
      return false;
    }
}