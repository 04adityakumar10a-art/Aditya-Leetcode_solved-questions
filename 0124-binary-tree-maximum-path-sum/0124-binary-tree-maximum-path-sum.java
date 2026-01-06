class Solution {
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;

        int left = Math.max(0, helper(root.left));
        int right = Math.max(0, helper(root.right));

        // path passing THROUGH this node
        int currentPath = root.val + left + right;

        // update global maximum
        max = Math.max(max, currentPath);

        // return path going UP (only one side allowed)
        return root.val + Math.max(left, right);
    }
}