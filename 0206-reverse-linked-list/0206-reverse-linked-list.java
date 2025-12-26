class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;     // will become the new head
        ListNode curr = head;     // start from old head

        while (curr != null) {
            ListNode nextNode = curr.next; // save next
            curr.next = prev;              // reverse pointer
            prev = curr;                   // move prev forward
            curr = nextNode;               // move curr forward
        }

        return prev; // new head of reversed list
    }
}
