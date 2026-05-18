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
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        // While the queue has nodes:
        while (!q.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            // - Record how many nodes are in the current queue (this is the current level size)
            int levelSize = q.size();
            // - Remove that many nodes, recording their values and adding their children to the queue
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = q.poll();
                level.add(node.val);
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            // - Add the recorded values as one level in the result
            res.add(level);
        }
        return res;
    }
}
