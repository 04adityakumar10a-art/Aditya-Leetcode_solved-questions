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
    public void inorder(ArrayList<Integer> ls,TreeNode root)
    {
        if(root==null) return ;
        inorder(ls,root.left);
        ls.add(root.val);
        inorder(ls,root.right);
    }
    public TreeNode maketree(ArrayList<Integer> ls,int start,int end)
    {
        if(start>end) return null;
        int mid=(start+end)/2;
        TreeNode node = new TreeNode(ls.get(mid));
        node.left=maketree(ls,start,mid-1);
        node.right=maketree(ls,mid+1,end);
        return node;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return null;
        ArrayList<Integer> ls= new ArrayList<>();
        inorder(ls,root);
        if(ls.contains(key))
        {ls.remove(Integer.valueOf(key));
        return maketree(ls,0,ls.size()-1);}
        else return root;
    }
}