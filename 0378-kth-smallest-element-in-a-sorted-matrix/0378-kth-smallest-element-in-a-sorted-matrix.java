class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int rows = matrix.length;
        int cols= matrix[0].length;
         PriorityQueue<Integer> minheap = new PriorityQueue<>();
         int total = rows*cols;
        for(int i =0 ; i<rows ;i++)
        {
            for(int j= 0 ;j<cols ; j++)
            {  if(minheap.size()<total-k+1)
               minheap.add(matrix[i][j]);
               else 
               {
                minheap.add(matrix[i][j]);
                minheap.poll();
               }
            }
        }
        return minheap.peek();
    }
}