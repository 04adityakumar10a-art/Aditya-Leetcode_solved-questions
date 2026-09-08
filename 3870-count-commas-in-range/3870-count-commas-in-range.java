class Solution {
    public int countCommas(int n) {
        int count =0;
        while(n>=1000)
        {
            count++;
            n--;
        }
        return count ;
    }
}