class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return res;

        int m = matrix.length;
        int n = matrix[0].length;

        int top = 0, bottom = m - 1;
        int left = 0, right = n - 1;

        while (top <= bottom && left <= right) {
            // left -> right on the top row
            for (int j = left; j <= right; j++) {
                res.add(matrix[top][j]);
            }
            // shift top boundary down
            top++;
            // top -> bottom on the right column
            for (int i = top; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            // shift right boundary left
            right--;
            // right -> left on the bottom row (only if a row remains)
            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    res.add(matrix[bottom][j]);
                }
                // shift bottom boundary up
                bottom--;
            }
            // bottom -> top on the left column (only if a column remains)
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    res.add(matrix[i][left]);
                }
                // shift left boundary right
                left++;
            }
        }
        return res;
    }
}
