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
    public int maxLevelSum(TreeNode root) {
        if (root == null) return 0;

        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        int maxSum = Integer.MIN_VALUE;
        int bestLevel = 1;
        int level = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            int sum = 0;
            level++;

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                sum += node.val;
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }

            // If you want the earliest level in case of tie, use '>'.
            if (sum > maxSum) {
                maxSum = sum;
                bestLevel = level;
            }
        }
        return bestLevel;
    }
}
