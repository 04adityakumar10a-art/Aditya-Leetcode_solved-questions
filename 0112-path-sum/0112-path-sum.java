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
    public boolean isleafnode(TreeNode node)
    {if(node.left == null && node.right==null) return true ;
    return false ;}
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null) return false;
        Queue<TreeNode> q = new LinkedList<>();
         Queue<Integer> q1 = new LinkedList<>();
         q.add(root);  
         q1.add(root.val);                        
         while(!q.isEmpty())
         { int size=q.size();
          for(int i=0;i<size;i++)
         {
             TreeNode node=q.poll();
             int nodeval = q1.poll();
             if( nodeval==targetSum && isleafnode(node)) return true;
             if(node.left!=null){q.add(node.left);q1.add(node.left.val+nodeval);}
             if(node.right!=null){q.add(node.right);q1.add(node.right.val+nodeval);}
              }
             }
        return false;
    }
}