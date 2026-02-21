class Solution {
    public int countPrimeSetBits(int left, int right) {
        int count=0;
        HashSet<Integer> mp = new HashSet<>();
        mp.add(2); mp.add(3); mp.add(5); mp.add(7); mp.add(11); mp.add(13); mp.add(17); mp.add(19);
        for(int i=left ;i<=right;i++)
        { int setBits = Integer.bitCount(i);
          if(mp.contains(setBits)) count++;
        }
        return count;
    }
}