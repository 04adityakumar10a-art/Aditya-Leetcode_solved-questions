class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        int n = groupSizes.length;
        List<List<Integer>> ans = new ArrayList<>();
        HashMap<Integer, ArrayList<Integer>> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (mp.get(groupSizes[i]) == null) {
                ArrayList<Integer> ls = new ArrayList<>();
                ls.add(i);
                mp.put(groupSizes[i], ls);
            } else {
                ArrayList<Integer> ls = mp.get(groupSizes[i]);
                ls.add(i);
                mp.put(groupSizes[i], ls);
            }
        }
        for (int key : mp.keySet()) {
            ArrayList<Integer> ls = mp.get(key);
            if (ls.size() == key)
                ans.add(ls);
            else { 
                for(int i =0 ; i<ls.size();i+=key)
                    { int idx= i;
                     int j=0;
                     ArrayList<Integer> l1 = new ArrayList<>();
                     while(j<key)
                     { 
                      l1.add(ls.get(idx++));
                      j++;
                     }
                     ans.add(l1);
                    }
            }
        }
        return ans;

    }
}