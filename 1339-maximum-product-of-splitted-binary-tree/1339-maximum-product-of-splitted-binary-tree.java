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
    long value = 0;
    public int maxProduct(TreeNode root) {
        long totalSum = getTotalSum(root);
        int mod = 1_00_000_000_7;
        long dummy = maxProduct(root,totalSum);
        return (int)(value%mod);
    }
    public long getTotalSum(TreeNode root){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return root.val;
        }
        long sum = root.val + getTotalSum(root.left) + getTotalSum(root.right);
        return sum;
    }
    public long maxProduct(TreeNode root,long totalSum){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            value = Math.max(value,(totalSum - root.val) * root.val);
            return root.val;
        }
        long sum = root.val + maxProduct(root.left,totalSum) + maxProduct(root.right,totalSum);
        value = Math.max(value,(totalSum - sum) * sum);
        return sum;
    }
}