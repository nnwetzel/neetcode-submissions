class WordDictionary {

    private static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean end = false;
    }

    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            curr.children.putIfAbsent(c, new TrieNode());
            curr = curr.children.get(c);
        }
        curr.end = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int i, TrieNode node) {
        if (i == word.length()) return node.end;

        char c = word.charAt(i);
        if (c == '.') {
            for (TrieNode child : node.children.values()) {
                if (dfs(word, i + 1, child)) return true;
            }
            return false;
        }
        else {
            TrieNode next = node.children.get(c);
            if (next == null) return false;
            return dfs(word, i + 1, next);
        }
    }
}
