/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        flattenRecursive(head);
        return head;
    }
    
    private Node flattenRecursive(Node node) {
        Node curr = node;
        Node prev = null;
        
        while (curr != null) {
            if (curr.child != null) {
                Node next = curr.next;
                Node childTail = flattenRecursive(curr.child);
                
                // Connect current to child
                curr.next = curr.child;
                curr.child.prev = curr;
                curr.child = null;
                
                // Connect child tail to next
                if (next != null) {
                    childTail.next = next;
                    next.prev = childTail;
                }
                
                prev = childTail;
                curr = next;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
        
        return prev; // Return tail of the flattened list
    }
}