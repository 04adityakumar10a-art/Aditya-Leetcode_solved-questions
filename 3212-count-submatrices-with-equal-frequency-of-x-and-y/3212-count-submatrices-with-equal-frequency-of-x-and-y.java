class Solution {
    public int numberOfSubmatrices(char[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        int[][] mat = new int[n][m];
        int[][] xcount = new int[n][m];


        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='X'){
                    mat[i][j] = 1;
                    xcount[i][j] = 1;

                }else if(grid[i][j]=='Y'){
                    mat[i][j] = -1;
                }else{
                    mat[i][j] = 0;
                }
            }
        }

        boolean flag = true;


        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]!=0){
                    flag = false;
                    break;
                }
            }
        }

        if(flag){
            return 0;
        }

        int ans = 0;


        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                

                if(i-1>=0){
                    mat[i][j]+=mat[i-1][j];
                    xcount[i][j]+=xcount[i-1][j];
                }

                if(j-1>=0){
                    mat[i][j]+=mat[i][j-1];
                    xcount[i][j]+=xcount[i][j-1];
                }


                if(i-1>=0 && j-1>=0){
                    mat[i][j]-=mat[i-1][j-1];
                     xcount[i][j]-=xcount[i-1][j-1];
                }

                if(mat[i][j]==0 && xcount[i][j]>0){
                    ans++;
                }
            }
        }

        return ans;
        
    }
}