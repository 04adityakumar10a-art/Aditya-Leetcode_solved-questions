class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        int pushes = 1;
        int ans = 0;

        while (n > 0) {
            int take = Math.min(8, n);
            ans += take * pushes;
            n -= take;
            pushes++;
        }

        return ans;
    }
}