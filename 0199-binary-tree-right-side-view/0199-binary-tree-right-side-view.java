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
    HashMap<Integer,Integer> hm = new HashMap<>();
    public void solve(TreeNode root,int c)
    {
        if(root == null)
        return;
        if(!hm.containsKey(c))
        hm.put(c,root.val);
        
        solve(root.right,c+1);
        solve(root.left,c+1);
    }
    public List<Integer> rightSideView(TreeNode root) {
        solve(root,1);
        List<Integer> al = new ArrayList<>(hm.values());
        return al;
    }
}