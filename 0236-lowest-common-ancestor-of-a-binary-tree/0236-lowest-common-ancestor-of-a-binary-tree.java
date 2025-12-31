/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || root==p ||root==q) return root ;
        TreeNode lc = lowestCommonAncestor( root.left, p, q);
        TreeNode rc = lowestCommonAncestor( root.right, p, q);
        if(lc==null)
          return rc;
        if(rc==null)
           return lc;
           else return root;   
    }
}