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
    public int count(ListNode head)
    {   int count=0;
        ListNode ctr=head;
        while(ctr!=null) {count++;ctr=ctr.next;}
        return count;
    }
    public ListNode deleteMiddle(ListNode head) {
        if (head.next==null) return null;
        if(head.next.next==null)
        {
            head.next=null;
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        int count = count(head)/2;
        
        int x=0;
        while(x<count-1)
        {  x++;
          slow=slow.next;
        }

        slow.next=slow.next.next;
       
        

        return head;
    }
}