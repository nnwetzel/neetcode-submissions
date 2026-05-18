class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visited = new HashSet<>();

        // dfs returns false when we have a cycle
        if (!dfs(0, -1, visited, adj)) return false;

        return visited.size() == n;
    }

    public boolean dfs(int node, int parent, Set<Integer> visited, List<List<Integer>> adj) {
        if (visited.contains(node)) return false;

        visited.add(node);

        for (int nei : adj.get(node)) {
            // we use parent to ignore the edge we came from so DFS doesn't mistake it for a cycle 
            if (nei == parent) continue;
            if (!dfs(nei, node, visited, adj)) return false;
        }
        return true;
    }
}
