class Solution {
    public int commoncheck(HashMap<Integer,Integer> mp ,int[] B,int end)
    {   int count=0;
        for(int j =0;j<=end;j++)
        {
            if(mp.containsKey(B[j]))
            {
                if(mp.get(B[j])<=end) count++;
            }
        }
        return count;
    }
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] C= new int[A.length];
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int i=0;i<A.length;i++)
        {
            mp.put(A[i],i);
        }
        for(int j=0;j<B.length;j++)
        {
            C[j]=commoncheck(mp,B,j);
        }
        return C;
    }
}