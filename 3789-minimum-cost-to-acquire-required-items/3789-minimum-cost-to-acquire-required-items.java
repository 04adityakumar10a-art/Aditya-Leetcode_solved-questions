
class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth,
            int need1, int need2) {

        long c1 = cost1;
        long c2 = cost2;
        long cb = costBoth;
        long n1 = need1;
        long n2 = need2;

        long common = Math.min(n1, n2);
        long remaining = Math.abs(n1 - n2);

        long ans = common * cb
                + (n1 > n2 ? remaining * c1 : remaining * c2);

        ans = Math.min(ans, Math.max(n1, n2) * cb);
        ans = Math.min(ans, n1 * c1 + n2 * c2);

        return ans;
    }
}
