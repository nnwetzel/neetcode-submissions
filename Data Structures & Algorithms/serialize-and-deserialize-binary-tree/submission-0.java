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

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return dfsSerialize(root, new StringBuilder()).toString();
    }

    private StringBuilder dfsSerialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null,");
        }
        else {
            sb.append(root.val).append(",");
            dfsSerialize(root.left, sb);
            dfsSerialize(root.right, sb);
        }
        return sb;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<String> nodes = new LinkedList<>(Arrays.asList(data.split(",")));
        return dfsDeserialize(nodes);
    }

    private TreeNode dfsDeserialize(List<String> nodes) {
        if (nodes.isEmpty()) return null;

        String val = nodes.remove(0);
        if (val.equals("null")) return null;

        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = dfsDeserialize(nodes);
        root.right = dfsDeserialize(nodes);
        return root;
    }
}
