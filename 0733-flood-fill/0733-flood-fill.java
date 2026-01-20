class Solution {
    static class Pair {
        int row, col;
        Pair(int i, int j) {
            this.row = i;
            this.col = j;
        }
    }
    public static void bfs(int[][] image, int sr, int sc, int orgclr,int color)
    { Stack<Pair> st= new Stack<>();
     int m = image.length;
     int n = image[0].length;
      st.push(new  Pair(sr,sc));
      while(!st.isEmpty())
      {  Pair val= st.pop(); 
         int i= val.row;
         int j = val.col;
         if(image[i][j]==orgclr)
         {  
           // update
            image[i][j]=color;
            //left
            if(j>0) st.push(new Pair(i,j-1));
           //right
            if(j<n-1) st.push(new Pair(i,j+1));
           //up
            if(i>0) st.push(new Pair(i-1,j));
           //down
           if(i<m-1)  st.push(new Pair(i+1,j));

           
         }
      }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int orgclr= image[sr][sc];
        if (orgclr == color) return image;
        bfs(image ,sr ,sc,orgclr,color);
        return image;
    }
}