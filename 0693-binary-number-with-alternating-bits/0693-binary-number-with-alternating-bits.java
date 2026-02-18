class Solution {
    public boolean hasAlternatingBits(int n) {
        int prev =2;
                while(n>0)
        { int curr = n%2;
          if (curr==prev) return false;
          else prev=curr;
          n=n/2;
        }
        return true;
    }
}