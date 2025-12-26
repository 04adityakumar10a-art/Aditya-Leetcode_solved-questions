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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null) return head;
        int size =0;
        ListNode ptr = head;
        while(ptr.next!=null)
       { ptr=ptr.next;
        size++;}
        size++;
        int realshift =k % size;
      if (realshift==0) return head;
        ptr.next=head;
        
        int i=1;
        while(i<size-realshift)
        {
            head=head.next;
            i++;
        }
        ptr= head.next;
        head.next=null;
        return ptr;
    }
}