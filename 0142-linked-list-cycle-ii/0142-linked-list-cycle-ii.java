/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> hs = new HashSet<>();
        ListNode current = head;
        while(current != null){
            if(hs.contains(current)){
                return current;
            }
            hs.add(current);
            current = current.next;
        }
        return null;
    }
}