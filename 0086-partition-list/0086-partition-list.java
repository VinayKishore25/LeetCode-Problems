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
    public ListNode partition(ListNode head, int x) {
        ListNode lowerBound = new ListNode(0), upperBound = new ListNode(0);
        ListNode result = lowerBound, upperReference = upperBound;
        ListNode current = head;
        while(current != null){
            if(current.val < x){
                lowerBound.next = new ListNode(current.val);
                lowerBound = lowerBound.next;
            }
            else{
                upperBound.next = new ListNode(current.val);
                upperBound = upperBound.next;
            }
            current = current.next;
        }
        lowerBound.next = upperReference.next;
        return result.next;
    }
}