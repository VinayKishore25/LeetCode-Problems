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
        ListNode res = new ListNode(-1);
        ListNode demo = res;
        int carry = 0,sum = 0;
        while(l1!=null || l2!=null)
        {
            
            if(l1!=null && l2!=null)
            {
                int x = l1.val;
                int y = l2.val;
                int z = x+y+carry;
                sum = z%10;
                carry = z/10;
                
                res.next = new ListNode(sum);
                res = res.next;
                l1 = l1.next;
                l2 = l2.next;
            }
            else if(l1 == null)
            {
                int y = l2.val;
                int z = y + carry;
                sum = z%10;
                carry = z/10;
                
                res.next = new ListNode(sum);
                res = res.next;
                l2 = l2.next;
            }
            else if(l2 == null)
            {
                int y = l1.val;
                int z = y + carry;
                sum = z%10;
                carry = z/10;
                
                res.next = new ListNode(sum);
                res = res.next;
                l1 = l1.next;
            }
           
        }
         if(carry!=0)
            {
                res.next = new ListNode(carry);
                res = res.next;
            }
        return demo.next;
    }
}