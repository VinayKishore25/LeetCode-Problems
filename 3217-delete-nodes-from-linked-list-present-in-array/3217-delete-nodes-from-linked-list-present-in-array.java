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
    public ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer> hs = new HashSet<>();
        for(int num:nums){
            hs.add(num);
        }
        while(hs.contains(head.val))
        {
            // res = head.next;
            head = head.next;
        }
        ListNode res = head;
        while(head.next!=null){
            if(hs.contains(head.next.val)){
                head.next = head.next.next;
            }
            else{
                head = head.next;
            }
        }
        return res;
    }
}