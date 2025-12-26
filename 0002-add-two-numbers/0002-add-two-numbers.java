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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ptr1=l1;
        ListNode ptr2=l2;
        ListNode dummy=new ListNode(0);
        ListNode curr=dummy;
        int carry=0;
        while(ptr1!=null || ptr2!=null|| carry!=0)
        {  int val1 = (ptr1 != null) ? ptr1.val : 0;
            int val2 = (ptr2 != null) ? ptr2.val : 0;
            curr.next=new ListNode((val1+val2+carry)%10);
         if(val1+val2+carry>=10) carry=1;
         else carry=0;
          curr=curr.next;
          if(ptr1!=null)
          ptr1=ptr1.next;
          if(ptr2!=null)
          ptr2=ptr2.next;
        }
        return dummy.next;
    }
}