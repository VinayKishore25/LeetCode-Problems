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
        if(head == null || head.next == null) return head;
        ListNode node = head;
        int length = 0;
        while(node != null){
            node = node.next;
            length++;
        }
        k %= length;
        if(k == length || k == 0) return head;
        int position = length - k;
        ListNode result = head;
        node = head;
        while(node != null){
            position--;
            if(position == 0){
                result = node.next;
                node.next = null;
            }
            node = node.next;
        }
        ListNode resultReference = result;
        while(result.next != null){
            result = result.next;
        }
        result.next = head;
        return resultReference;
    }
}