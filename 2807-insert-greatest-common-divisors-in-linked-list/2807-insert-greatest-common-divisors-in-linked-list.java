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
    public int gcd(int a,int b){
        if(a == 0){
            return b;
        }
        return gcd(b%a,a);
    }
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode res = head;
        System.out.println(gcd(6,10));
        while(head.next != null){
            int a = head.val;
            int b = head.next.val;
            int val = gcd(a,b);
            ListNode temp = new ListNode(val);
            temp.next = head.next;
            head.next = temp;
            head = head.next.next;
        }
        return res;
    }
}