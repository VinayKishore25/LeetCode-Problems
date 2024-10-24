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
    public ListNode insertionSortList(ListNode head_ref) {
        ListNode temp = null , head = new ListNode(-100001) , prev = null;
        while(head_ref != null)
        {
            temp = head;
            prev = null;
            while(temp != null && head_ref.val > temp.val)
            {
                prev = temp;
                temp = temp.next;
            }
            prev.next = head_ref;
            // System.out.println(prev.val);
            head_ref=head_ref.next;
            prev.next.next = temp;
        }
        return head.next;
    }
}