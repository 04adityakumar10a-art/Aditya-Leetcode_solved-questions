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
    int preIndex = 0;
    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Store inorder positions
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return construct(preorder, 0, inorder.length - 1);
    }

    private TreeNode construct(int[] preorder, int left, int right) {
        if (left > right) return null;

        // Root from preorder
        int rootVal = preorder[preIndex++];
        TreeNode root = new TreeNode(rootVal);

        // Split inorder
        int mid = map.get(rootVal);

        // Build left and right subtree
        root.left = construct(preorder, left, mid - 1);
        root.right = construct(preorder, mid + 1, right);

        return root;
    }
}
