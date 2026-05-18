class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isWord = false;

    public void addWord(String word) {
        TrieNode curr = this;
        for (char c : word.toCharArray()) {
            curr.children.putIfAbsent(c, new TrieNode());
            curr = curr.children.get(c);
        }
        curr.isWord = true;
    }
}

class Solution {

    private Set<String> foundWords;
    private boolean[][] visited;
    private int ROWS, COLS;

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            root.addWord(w);
        }

        ROWS = board.length;
        COLS = board[0].length;

        foundWords = new HashSet<>();
        visited = new boolean[ROWS][COLS];

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                dfs(board, r, c, root, "");
            }
        }
        return new ArrayList<>(foundWords);
    }

    private void dfs(char[][] board, int r, int c, TrieNode node, String word) {
        // Base case: out of bounds
        if (r < 0 || c < 0 || r >= ROWS || c >= COLS) return;
        // Base case: already used this cell in the current path
        if (visited[r][c]) return;

        char ch = board[r][c];

        TrieNode nextNode = node.children.get(ch);
        if (nextNode == null) return;
        
        visited[r][c] = true;
        String newWord = word + ch;

        if (nextNode.isWord) foundWords.add(newWord);

        dfs(board, r + 1, c, nextNode, newWord);
        dfs(board, r, c + 1, nextNode, newWord);
        dfs(board, r - 1, c, nextNode, newWord);
        dfs(board, r, c - 1, nextNode, newWord);

        visited[r][c] = false;
    }
}
