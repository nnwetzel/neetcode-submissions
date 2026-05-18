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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) return null;

        // root is the first element of preorder
        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);

        // Find root index in inorder to split left/right
        int mid = 0;
        while (inorder[mid] != rootVal) mid++;

        // Build left and right using array slices
        root.left = buildTree(
            Arrays.copyOfRange(preorder, 1, 1 + mid),
            Arrays.copyOfRange(inorder, 0, mid)
        );
        root.right = buildTree(
            Arrays.copyOfRange(preorder, 1 + mid, preorder.length),
            Arrays.copyOfRange(inorder, mid + 1, inorder.length)
        );

        return root;
    }
}
