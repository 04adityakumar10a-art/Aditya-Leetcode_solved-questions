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
import java.util.*;

class Solution {
    public int sumRootToLeaf(TreeNode root) {
        if (root == null) return 0;
        
        int sum = 0;
        Queue<Pair> queue = new LinkedList<>();
        
        queue.offer(new Pair(root, 0));
        
        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            TreeNode node = p.node;
            int current = p.value * 2 + node.val;
            
            // If leaf node
            if (node.left == null && node.right == null) {
                sum += current;
            }
            
            if (node.left != null) {
                queue.offer(new Pair(node.left, current));
            }
            
            if (node.right != null) {
                queue.offer(new Pair(node.right, current));
            }
        }
        
        return sum;
    }
    
    // Helper class
    class Pair {
        TreeNode node;
        int value;
        
        Pair(TreeNode node, int value) {
            this.node = node;
            this.value = value;
        }
    }
}