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
    public TreeNode maketree(int nums[],int start ,int end)
    {   if(start > end ) return null;
        int mid =(start+end)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.right =maketree( nums,mid+1 ,end);
        node.left =maketree(nums,start ,mid-1);
         return node;
    }
    
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0) return null;
         if(nums.length==1) return  new TreeNode(nums[0]);
         if(nums.length==2)
         { TreeNode root =  new TreeNode(nums[1]);
           root.left= new TreeNode(nums[0]);
       root.right=null;
       return root;
             }
        int mid;
        if (nums.length%2==0)
        { mid =nums.length /2 ;}
        else { mid =nums.length/2; }
        TreeNode root = new TreeNode(nums[mid]);
        return maketree( nums ,0 ,nums.length-1);

    }
}