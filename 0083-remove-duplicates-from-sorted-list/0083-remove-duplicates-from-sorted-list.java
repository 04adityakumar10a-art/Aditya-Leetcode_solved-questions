/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr= head;
        ListNode ans = head;
        if(head==null || head.next==null) return head;
       while(head.next!= null)
       {
        if(head.next!=null && head.val==head.next.val)
          head=head.next;
        if(head.next!=null && head.val!=head.next.val)
         { curr.next=head.next;
            head=head.next;
            curr=curr.next;}   
            
       }
       curr.next=null;
        return ans;
    }
}