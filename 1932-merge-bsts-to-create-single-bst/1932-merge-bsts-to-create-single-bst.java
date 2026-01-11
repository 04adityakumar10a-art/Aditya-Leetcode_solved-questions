class Solution {
    Map<Integer, TreeNode> map = new HashMap<>();
    Set<Integer> used = new HashSet<>();

    public TreeNode canMerge(List<TreeNode> trees) {

        // map root value -> tree
        for (TreeNode t : trees) {
            map.put(t.val, t);
        }

        // collect all leaf values
        Set<Integer> leaves = new HashSet<>();
        for (TreeNode t : trees) {
            if (t.left != null) leaves.add(t.left.val);
            if (t.right != null) leaves.add(t.right.val);
        }

        // find final root
        TreeNode root = null;
        for (TreeNode t : trees) {
            if (!leaves.contains(t.val)) {
                root = t;
                break;
            }
        }

        if (root == null) return null;

        // try to merge
        if (!dfs(root, Integer.MIN_VALUE, Integer.MAX_VALUE))
            return null;

        // all trees must be used
        if (used.size() != trees.size() - 1)
            return null;

        return root;
    }

    private boolean dfs(TreeNode node, int low, int high) {
        if (node == null) return true;

        if (node.val <= low || node.val >= high)
            return false;

        // merge at leaf
        if (node.left == null && node.right == null && map.containsKey(node.val)) {
            TreeNode t = map.get(node.val);
            if (t != node) {
                node.left = t.left;
                node.right = t.right;
                used.add(t.val);
            }
        }

        return dfs(node.left, low, node.val) &&
               dfs(node.right, node.val, high);
    }
}
