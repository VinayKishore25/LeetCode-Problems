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
    int ans = Integer.MIN_VALUE;
    public void solve(TreeNode root,int c)
    {
        if(root==null)
        return;
        if(root.left == null && root.right == null)
        {
            ans = Math.max(ans,c);
        }
        solve(root.left,c+1);
        solve(root.right,c+1);
    }
    public int maxDepth(TreeNode root) {
        if(root == null)return 0;
        solve(root,1);
        return ans;
    }
}