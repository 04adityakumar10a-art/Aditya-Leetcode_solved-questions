class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;

        // Step 1: Create a dummy node to simplify edge cases
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        // Step 2: Move to the node just before the 'left' position
        ListNode prevsublist = dummy;
        for (int i = 1; i < left; i++) {
            prevsublist = prevsublist.next;
        }

        // Step 3: Start reversing from 'left' to 'right'
        ListNode curr = prevsublist.next;
        ListNode next = null;
        ListNode prev = null;

        for (int i = left; i <= right; i++) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // Step 4: Connect the reversed part back to the list
        prevsublist.next.next = curr;     // Tail of reversed part points to rest of list
        prevsublist.next = prev;  // Node before 'left' points to new head of reversed part

        return dummy.next;
    }
}
