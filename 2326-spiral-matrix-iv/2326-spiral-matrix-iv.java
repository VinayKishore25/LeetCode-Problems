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
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] res = new int[m][];
        for (int i = 0; i < m; i++) {
            res[i] = new int[n];
            Arrays.fill(res[i], -1);
        }
        int rs = 0 , re = m - 1 , cs = 0 , ce = n -1;
        while(head != null){
            int i = cs;
            while(head != null && i <= ce){
                res[rs][i] = head.val;
                head = head.next;
                i++;
            }
            rs++;
            i = rs;
            while(head != null && i <= re){
                res[i][ce] = head.val;
                head = head.next;
                i++;
            }
            ce--;
            i = ce;
            while(head != null && i >= cs){
                res[re][i] = head.val;
                head = head.next;
                i--;
            }
            re--;
            i = re;
            while(head != null && i >= rs){
                res[i][cs] = head.val;
                head = head.next;
                i--;
            }
            cs++;
        }
        return res;
    }
}