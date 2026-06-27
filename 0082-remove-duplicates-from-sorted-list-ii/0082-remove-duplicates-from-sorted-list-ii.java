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
        ListNode current = head;
        ListNode result = new ListNode(0);
        ListNode resultReference = result;
        while(current != null){
            if(current.next != null && current.val == current.next.val){
                while(current.next != null && current.val == current.next.val){
                    current = current.next;
                }
                current = current.next;
            }
            else{
                result.next = new ListNode(current.val);
                result = result.next;
                current = current.next;
            }
        }
        return resultReference.next;
    }
}