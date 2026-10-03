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
    public boolean isValidBST(TreeNode root) {
        return solve(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    public boolean solve(TreeNode root, int min, int max) {
        if(root == null) return true;
        if(root.val > min && root.val < max) {
            return(solve(root.left, min, root.val) && solve(root.right, root.val, max));
        }
        return false;
    }
}
