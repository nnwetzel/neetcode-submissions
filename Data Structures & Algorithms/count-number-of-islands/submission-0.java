class Solution {
    private int ROWS, COLS;

    public int numIslands(char[][] grid) {


        ROWS = grid.length;
        COLS = grid[0].length;
        int numIslands = 0;

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == '1') {
                    numIslands++;
                    dfs(grid, r, c);
                }
            }
        }
        return numIslands;
    }

    private void dfs(char[][] grid, int r, int c) {
        // Check for out of bounds
        if (r < 0 || c < 0 || r >= ROWS || c >= COLS) return;
        // Check if already visited
        if (grid[r][c] == '0') return;

        // Mark current cell as already visited - if it's part of the island make it '0'
        grid[r][c] = '0';

        // Explore all adjacent cell and do the same
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }
}
