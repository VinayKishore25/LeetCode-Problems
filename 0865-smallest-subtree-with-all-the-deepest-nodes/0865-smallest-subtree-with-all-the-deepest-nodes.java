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
    int depth = 0;
    TreeNode ans;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        solve(root,hm,1);
        int totalDepthNodes = hm.get(depth);
        System.out.println(totalDepthNodes);
        ans = null;
        int val = getAncestor(root,1,totalDepthNodes);
        if(ans == null){
            return root;
        }
        return ans;
    }

    public void solve(TreeNode root,HashMap<Integer,Integer> hm,int level){
        if(root == null){
            return;
        }
        depth = Math.max(depth,level);
        hm.put(level,hm.getOrDefault(level,0)+1);
        solve(root.left,hm,level+1);
        solve(root.right,hm,level+1);
    }
    public int getAncestor(TreeNode root,int level,int totalDepthNodes){
        if(root == null){
            return 0;
        }
        if(ans != null){
            return 0;
        }
        if(level == depth){
            if(totalDepthNodes == 1){
                ans = root;
            }
            return 1;
        }
        
        int totalNodes = 0;
        totalNodes += getAncestor(root.left,level+1,totalDepthNodes) + getAncestor(root.right,level+1,totalDepthNodes);
        if(totalNodes == totalDepthNodes && ans == null){
            ans = root;
        }
        return totalNodes;
    }
}