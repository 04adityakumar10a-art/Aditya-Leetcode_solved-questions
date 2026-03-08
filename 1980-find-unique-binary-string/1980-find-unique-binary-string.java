import java.util.*;

class Solution {
    public String findDifferentBinaryString(String[] nums) {

        HashSet<String> set = new HashSet<>();

        for(String s : nums)
            set.add(s);

        int n = nums.length;

        return dfs(new StringBuilder(), n, set);
    }

    public String dfs(StringBuilder cur, int n, HashSet<String> set)
    {
        if(cur.length() == n)
        {
            String s = cur.toString();
            if(!set.contains(s))
                return s;
            return "";
        }

        cur.append('0');
        String res = dfs(cur,n,set);
        if(!res.equals("")) return res;
        cur.deleteCharAt(cur.length()-1);

        cur.append('1');
        res = dfs(cur,n,set);
        if(!res.equals("")) return res;
        cur.deleteCharAt(cur.length()-1);

        return "";
    }
}