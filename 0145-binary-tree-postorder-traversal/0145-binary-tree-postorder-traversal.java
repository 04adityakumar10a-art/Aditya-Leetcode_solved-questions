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
     public static void preorder(TreeNode root,ArrayList ls)
    {
        if(root==null) return;
       
        preorder(root.left,ls);
        preorder(root.right,ls);
         ls.add(root.val);
    }
    public List<Integer> postorderTraversal(TreeNode root) {
         ArrayList<Integer> ls= new ArrayList<>();
        preorder(root, ls);
        return ls;
    }
}