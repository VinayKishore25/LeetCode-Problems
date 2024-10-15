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

    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> al = new ArrayList<>();
        if(root==null)return al;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            int n = q.size();
            List<Integer> l = new ArrayList<>();
            for(int i = 0 ; i < n ; i++)
            {
                TreeNode res = q.peek();
                q.poll();
                l.add(res.val);
                if(res.left!=null)q.add(res.left);
                if(res.right != null)q.add(res.right);
            }
            al.add(l);
        }
        return al;
    }
}