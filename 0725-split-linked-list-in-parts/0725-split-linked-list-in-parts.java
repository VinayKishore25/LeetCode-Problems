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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode temp = head;
        int length  = 0;
        while(temp != null){
            temp = temp.next;
            length++;
        }
        ListNode[] res = new ListNode[k];
        int perPart = length/k;
        int remPart = length%k;
        temp = head;
        int j = 0;
        while(temp != null){
            int len = perPart;
            while(temp != null && len > 0){
                if(res[j] == null) res[j] = temp;
                len--;
                if(remPart == 0 && len == 0){
                    ListNode flag = temp.next;
                    temp.next = null;
                    temp = flag;
                    continue;
                }
                temp = temp.next;
            }
            if(remPart > 0){
                if(res[j] == null) res[j] = temp;
                ListNode flag = temp.next;
                temp.next = null;
                temp = flag;
                remPart--;
            }
            j++;
        }
        return res;
    }
}