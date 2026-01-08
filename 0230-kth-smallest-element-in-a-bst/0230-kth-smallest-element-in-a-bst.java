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
    public void makeorder(ArrayList<Integer> ls,TreeNode root)
    {
        if(root==null) return ;
        makeorder(ls, root.left);
        ls.add(root.val);
        makeorder(ls,root.right);
    }
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> ls = new ArrayList<>();
        makeorder(ls,root);
        return ls.get(k-1);
    }
}