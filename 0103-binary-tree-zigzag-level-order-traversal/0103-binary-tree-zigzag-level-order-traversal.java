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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root==null) return new ArrayList<>();
        ArrayList<List<Integer>> ls = new ArrayList<>();
        Stack<TreeNode> s1= new Stack<>();
        Stack<TreeNode> s2= new Stack<>();
        s1.push(root);
        while(!s1.isEmpty() || !s2.isEmpty())
        {   
          ArrayList<Integer> l= new ArrayList<>();
          if(!s1.isEmpty())
         {while(!s1.isEmpty())
          {  TreeNode node = s1.pop();
              l.add(node.val);
             if(node.left!=null) s2.push(node.left);
             if(node.right!=null) s2.push(node.right);
          }}
          else
          {
           while(!s2.isEmpty())
          {  TreeNode node = s2.pop();
              l.add(node.val);
              if(node.right!=null) s1.push(node.right);
             if(node.left!=null) s1.push(node.left);
             
          }}
            ls.add(l);
        }
        return ls;
    }
}