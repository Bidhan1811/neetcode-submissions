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
    int preIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < preorder.length; i++) {
            map.put(inorder[i], i);
        }
        TreeNode root = solve(0, inorder.length - 1, preorder, map, inorder);
        return root;
    }
    public TreeNode solve(int inStart, int inEnd, int[] preorder, HashMap<Integer, Integer> map, int[] inorder) {
        if(inStart > inEnd) return null;
        TreeNode root = new TreeNode(preorder[preIndex]);
        preIndex++;
        int rootIndex = map.get(root.val);
        root.left = solve(inStart, rootIndex - 1, preorder, map, inorder);
        root.right = solve(rootIndex + 1, inEnd, preorder, map, inorder);
        return root;
    }
}
