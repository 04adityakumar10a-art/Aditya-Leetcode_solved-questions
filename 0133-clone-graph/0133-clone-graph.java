/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {

    public Node cloneGraph(Node node) {
        if (node == null) return null;

        HashMap<Node, Node> mp = new HashMap<>();
        Queue<Node> q = new LinkedList<>();

        // create clone of start node
        mp.put(node, new Node(node.val));
        q.add(node);

        while (!q.isEmpty()) {
            Node curr = q.poll();

            for (Node neb : curr.neighbors) {

                // if neighbor not cloned yet
                if (!mp.containsKey(neb)) {
                    mp.put(neb, new Node(neb.val));
                    q.add(neb);
                }

                // add cloned neighbor
                mp.get(curr).neighbors.add(mp.get(neb));
            }
        }

        return mp.get(node);
    }
}
