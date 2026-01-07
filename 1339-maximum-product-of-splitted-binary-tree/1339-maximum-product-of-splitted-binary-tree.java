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
    static long max;
    static long sum;
    static long mod = 1_00_000_000_7;
    public int maxProduct(TreeNode root) {
        max = 0;
        long totalSum = getTotalSum(root);
        maxProduct(root,totalSum);
        return (int)(max%mod);
    }
    public long getTotalSum(TreeNode root){
        if(root == null){
            return 0;
        }
        return root.val + getTotalSum(root.left) + getTotalSum(root.right);
    }
    public long maxProduct(TreeNode root,long totalSum){
        if(root == null){
            return 0;
        }
        
        long sum = root.val + maxProduct(root.left,totalSum) + maxProduct(root.right,totalSum);
        long temp = (totalSum - sum) * sum;
        if(temp > max){
            max = temp;
        }
        return sum;
    }
}