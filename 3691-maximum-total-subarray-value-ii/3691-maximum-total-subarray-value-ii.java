import java.util.*;

class Solution {

    private int[][] maxST;
    private int[][] minST;
    private int[] log;

    private long value(int l, int r) {
        int len = r - l + 1;
        int k = log[len];

        int mx = Math.max(
                maxST[k][l],
                maxST[k][r - (1 << k) + 1]
        );

        int mn = Math.min(
                minST[k][l],
                minST[k][r - (1 << k) + 1]
        );

        return (long) mx - mn;
    }

    private void buildSparseTables(int[] nums) {
        int n = nums.length;

        log = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            log[i] = log[i / 2] + 1;
        }

        int K = log[n] + 1;

        maxST = new int[K][n];
        minST = new int[K][n];

        for (int i = 0; i < n; i++) {
            maxST[0][i] = nums[i];
            minST[0][i] = nums[i];
        }

        for (int k = 1; k < K; k++) {
            int len = 1 << k;

            for (int i = 0; i + len <= n; i++) {

                maxST[k][i] = Math.max(
                        maxST[k - 1][i],
                        maxST[k - 1][i + (len >> 1)]
                );

                minST[k][i] = Math.min(
                        minST[k - 1][i],
                        minST[k - 1][i + (len >> 1)]
                );
            }
        }
    }

    static class Node {
        long val;
        int l;
        int r;

        Node(long val, int l, int r) {
            this.val = val;
            this.l = l;
            this.r = r;
        }
    }

    public long maxTotalValue(int[] nums, int k) {

        int n = nums.length;

        buildSparseTables(nums);

        PriorityQueue<Node> pq =
                new PriorityQueue<>((a, b) -> Long.compare(b.val, a.val));

        for (int l = 0; l < n; l++) {
            pq.offer(new Node(
                    value(l, n - 1),
                    l,
                    n - 1
            ));
        }

        long ans = 0;

        while (k-- > 0 && !pq.isEmpty()) {

            Node cur = pq.poll();

            ans += cur.val;

            if (cur.r > cur.l) {

                int nr = cur.r - 1;

                pq.offer(new Node(
                        value(cur.l, nr),
                        cur.l,
                        nr
                ));
            }
        }

        return ans;
    }
}