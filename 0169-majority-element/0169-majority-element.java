class Solution {
    public int majorityElement(int[] nums) {
        int n= nums.length;
        int MEI=n/2;
        HashMap<Integer,Integer> m= new HashMap<>();
        for(int x : nums)
         {if(m.containsKey(x))
          { int y=m.get(x);
            m.put(x,y+1);
          }
          else
             m.put(x,1);
         }
        for(int x : m.keySet())
        { if(m.get(x)>MEI)
            return x;
        }
     return 0; }
   
}