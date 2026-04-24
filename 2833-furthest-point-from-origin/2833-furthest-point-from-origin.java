class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int lc=0;
        int rc=0;
        int sp=0;
        for(int i=0;i<moves.length();i++)
        {
           if(moves.charAt(i)=='L') lc++;
          else if(moves.charAt(i)=='R') rc++;
           else sp++;
        }
        if(lc==rc) return sp;
        else return Math.abs(lc-rc)+sp;
    }
}