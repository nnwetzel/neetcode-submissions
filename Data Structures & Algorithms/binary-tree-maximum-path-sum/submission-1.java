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
    private int maxSum = 0;

    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;

        int left = Math.max(dfs(root.left), 0);
        int right = Math.max(dfs(root.right), 0);

        // Compute max path sum WITH split at this node
        // This will eventually find the root that can be split in which has the max value.
        maxSum = Math.max(maxSum, root.val + left + right);
        // Otherwise return the value at the root or with left and right added.
        // This is because we recurse on the assumption we cannot split at this root.
        return root.val + Math.max(left, right);
    }
}
