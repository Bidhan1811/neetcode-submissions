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
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        solve(root);
        return maxSum;
    }
    public int solve(TreeNode root) {
        if(root == null) return 0;
        int leftMaxSum = Math.max(0, solve(root.left));
        int rightMaxSum = Math.max(0, solve(root.right));
        int curr = leftMaxSum + root.val + rightMaxSum;
        maxSum = Math.max(curr, maxSum);
        return root.val + Math.max(leftMaxSum, rightMaxSum);
    }
}
