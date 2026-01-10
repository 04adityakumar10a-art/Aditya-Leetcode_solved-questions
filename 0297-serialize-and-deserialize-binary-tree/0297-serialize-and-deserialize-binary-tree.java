/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
     
     public void inorder(ArrayList<Integer> ls,TreeNode root)
    {
        if(root==null) return ;
        inorder(ls,root.left);
        ls.add(root.val);
        inorder(ls,root.right);
    }
    public TreeNode maketree(char[] ls,int start,int end)
    {
        if(start>end) return null;
        int mid=(start+end)/2;
        TreeNode node = new TreeNode(ls[mid]);
        node.left=maketree(ls,start,mid-1);
        node.right=maketree(ls,mid+1,end);
        return node;
    }
    // Encodes a tree to a single string.
   public String serialize(TreeNode root) {
    if (root == null) return "";

    StringBuilder sb = new StringBuilder();
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);

    while (!q.isEmpty()) {
        TreeNode node = q.poll();
        if (node == null) {
            sb.append("null,");
        } else {
            sb.append(node.val).append(",");
            q.add(node.left);
            q.add(node.right);
        }
    }
    return sb.toString();
}


public TreeNode deserialize(String data) {
    if (data == null || data.length() == 0) return null;

    String[] arr = data.split(",");
    TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);

    int i = 1;
    while (!q.isEmpty() && i < arr.length) {
        TreeNode node = q.poll();

        if (!arr[i].equals("null")) {
            node.left = new TreeNode(Integer.parseInt(arr[i]));
            q.add(node.left);
        }
        i++;

        if (i < arr.length && !arr[i].equals("null")) {
            node.right = new TreeNode(Integer.parseInt(arr[i]));
            q.add(node.right);
        }
        i++;
    }
    return root;
}
}


// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));