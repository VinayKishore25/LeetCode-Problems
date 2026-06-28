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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        return divide(head);
    }
    public ListNode divide(ListNode node){
        if(node == null || node.next == null){
            return node;
        }
        ListNode slow = node;
        ListNode fast = node;
        ListNode prev = null;
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode partition2 = prev.next;
        prev.next = null;
        ListNode partition1 = node;
        ListNode part1 = divide(partition1);
        ListNode part2 = divide(partition2);
        return merge(part1,part2);
    }
    public ListNode merge(ListNode part1, ListNode part2){
        ListNode result = new ListNode(0);
        ListNode resultReference = result;
        while(part1 != null && part2 != null){
            if(part1.val < part2.val){
                result.next = new ListNode(part1.val);
                result = result.next;
                part1 = part1.next;
            }
            else{
                result.next = new ListNode(part2.val);
                result = result.next;
                part2 = part2.next;
            }
        }
        while(part1 != null){
            result.next = new ListNode(part1.val);
            result = result.next;
            part1 = part1.next;
        }
        while(part2 != null){
            result.next = new ListNode(part2.val);
            result = result.next;
            part2 = part2.next;
        }
        return resultReference.next;
    }
}