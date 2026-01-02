/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    static class Pair {
        TreeNode node;
        long index;
        Pair(TreeNode n, long i) {
            node = n;
            index = i;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        int maxWidth = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            long minIndex = q.peek().index;   // to avoid overflow
            long first = 0, last = 0;

            for (int i = 0; i < size; i++) {
                Pair p = q.poll();
                long idx = p.index - minIndex;  // normalize

                if (i == 0) first = idx;
                if (i == size - 1) last = idx;

                if (p.node.left != null)
                    q.add(new Pair(p.node.left, 2 * idx));
                if (p.node.right != null)
                    q.add(new Pair(p.node.right, 2 * idx + 1));
            }

            maxWidth = Math.max(maxWidth, (int)(last - first + 1));
        }

        return maxWidth;
    }
}
