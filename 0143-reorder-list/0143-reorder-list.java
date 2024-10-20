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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = head;
        while(fast != null && fast.next!= null)
        {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode half = slow;
        prev.next = null;
        ListNode rev = reverse(half);
        // ListNode res = new ListNode(0);
        // ListNode ans = res;
        // while(head!=null)
        // {
        //     res.next = new ListNode(head.val);
        //     res = res.next;
        //     res.next = new ListNode(rev.val);
        //     res = res.next;
        //     head = head.next;
        //     rev = rev.next;
        // }
        // head = ans.next;
        // print(ans);
        // print(head);
        merge(head,rev);
    }
    public ListNode reverse(ListNode head)
    {
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;
        while(curr != null)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        // print(next);
        return prev;
    }
    // public void print(ListNode head)
    // {
    //     ListNode temp = head;
    //     while(temp != null)
    //     {
    //         System.out.print(temp.val + " -->");
    //         temp = temp.next;
    //     }
    //     System.out.println();
    // }
    public void merge(ListNode head,ListNode rev)
    {
        ListNode first = head;
        ListNode second = rev;
        ListNode temp = head;
        ListNode next = null;
        while (first != null) 
        {
            next = first.next;
            rev = second.next;
            first.next = second;
            second.next = next;
            first = next;
            second = rev;
        }
        while(temp.next != null)
        {
            temp = temp.next;
        }
        temp.next = rev;
        // print(head);
        
    }
}