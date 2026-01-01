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
   int postIndex ;
    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
         postIndex = postorder.length-1; 
        // Store inorder positions
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return construct(postorder, 0, inorder.length - 1);
    }

    private TreeNode construct(int[] postorder, int left, int right) {
       if (left > right || postIndex < 0) return null;
        int rootVal = postorder[postIndex--];
        int mid = map.get(rootVal);
        TreeNode root = new TreeNode(rootVal);

        // Build left and right subtree
      
        root.right = construct(postorder, mid + 1, right);
        root.left = construct(postorder, left, mid - 1);
        // Root from preorder
       
       
        return root;
    }
}
