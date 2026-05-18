/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        Map<Node, Node> oldToNew = new HashMap<>();
        return dfs(node, oldToNew);
    }

    private Node dfs(Node node, Map<Node, Node> oldToNew) {
        // Base case
        if (node == null) return null;
        // If we've already created this node, it's stored, so reuse it
        if (oldToNew.containsKey(node)) return oldToNew.get(node);
        // Otherwise, create this node and store it
        Node copy = new Node(node.val);
        oldToNew.put(node, copy);
        // Recurse on all node neighbors
        for (Node nei : node.neighbors) {
            copy.neighbors.add(dfs(nei, oldToNew));
        }
        return copy;
    }
}