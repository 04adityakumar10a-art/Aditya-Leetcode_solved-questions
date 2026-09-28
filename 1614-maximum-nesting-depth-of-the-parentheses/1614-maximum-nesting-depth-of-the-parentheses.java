class Solution {
    public int maxDepth(String s) {
        int maxi =0 ; int z=0;
        for(int i=0; i<s.length();i++)
        {
            if(s.charAt(i) == '(') 
            {z++;maxi=Math.max(maxi,z);}
             if(s.charAt(i) == ')') 
            {z--;maxi=Math.max(maxi,z);}
        }
        return maxi;
    }
}