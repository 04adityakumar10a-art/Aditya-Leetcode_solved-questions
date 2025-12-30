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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root==null) return  new ArrayList<>();
        List<List<Integer>> ls= new ArrayList<>();
        Queue<TreeNode> q= new LinkedList<>();
        TreeNode node =root;
        q.add(node);
        while(!q.isEmpty())
        {  int size=q.size();
             
            ArrayList<Integer> l1= new ArrayList<>();
             for (int i = 0; i < size; i++)
              {     node=q.poll();
                
                    l1.add(node.val);
                     if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
                }
             
                ls.add(l1);
                // if (node.left != null) q.add(node.left);
                // if (node.right != null) q.add(node.right);
        }
         return ls;
        }
       
    }
