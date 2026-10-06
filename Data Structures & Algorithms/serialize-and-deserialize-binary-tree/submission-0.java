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

public class Codec {
    StringBuilder encode = new StringBuilder();
    int index = 0;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        solveEncode(root);
        return encode.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] values = data.split(",");
        return solveDecode(values);
    }

    public void solveEncode(TreeNode root) {
        if(root == null) {
            encode.append("N,");
            return;
        }
        encode.append(Integer.toString(root.val) + ',');
        solveEncode(root.left);
        solveEncode(root.right);
        return;
    }

    public TreeNode solveDecode(String[] values) {
        if(values[index].equals("N")) {
            index++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(values[index]));
        index++;
        root.left = solveDecode(values);
        root.right = solveDecode(values);
        return root;
    }
}
