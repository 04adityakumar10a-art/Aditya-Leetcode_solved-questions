class Solution {
    public int numTrees(int n) {
        return recur(n);
    }

    public int recur(int n) {
        if (n <= 1) return 1;

        int ans = 0;

        for (int i = 1; i <= n; i++) {
            int left = recur(i - 1);
            int right = recur(n - i);

            ans += left * right;
        }

        return ans;
    }
}