class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int min=Integer.MAX_VALUE;
        for(int i=0; i<arr.length-1;i++)
        {  int diff= arr[i+1]-arr[i];
            min=Math.min(min,diff);
        }
       List<List<Integer>> l1 = new ArrayList<>();
        for(int i=0; i<arr.length-1;i++)
        {  int diff= arr[i+1]-arr[i];
            if(diff<=min)
            {
                List<Integer> ls= new ArrayList<>();
                ls.add(arr[i]);
                ls.add(arr[i+1]);
                l1.add(ls);
            }
        }
        return l1;
    }
}