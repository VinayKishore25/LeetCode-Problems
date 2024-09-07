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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean solve(ListNode head,ListNode curr,TreeNode root){
        if(curr == null) return true;
        if(root == null) return false;
        boolean pick = false;
        boolean nonPick = false;
        boolean nonPick2 = false;
        if(root.val == curr.val){
            pick = solve(head,curr.next,root.left) || solve(head,curr.next,root.right);
        }
        else{
            
            if(head.val == root.val){
                head = head.next;
                nonPick = solve(head,curr,root.left) || solve(head,curr,root.right);
            }
            else{
                curr = head;
                nonPick2 = solve(head,curr,root.left) || solve(head,curr,root.right);
            }
        }
        return pick || nonPick || nonPick2;
    }
    public boolean isSubPath(ListNode head, TreeNode root) {
        return solve(head,head,root);
    }
}