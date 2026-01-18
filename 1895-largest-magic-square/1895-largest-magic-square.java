class Solution {
    public int largestMagicSquare(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] rowsum = new int[m][n];
        for (int i = 0; i < m; i++) {
            rowsum[i][0] = grid[i][0];
            for (int j = 1; j < n; j++) {
                rowsum[i][j] = rowsum[i][j - 1] + grid[i][j];
            }
        }
        int[][] colsum = new int[m][n];
        for (int j = 0; j < n; j++) {
            colsum[0][j] = grid[0][j];
            for (int i = 1; i < m; i++) {
                colsum[i][j] = colsum[i - 1][j] + grid[i][j];
            }
        }
        for (int size = Math.min(m, n); size >= 2; size--) {
            for (int i = 0; i + size <= m; i++) {
                for (int j = 0; j + size <= n; j++) {
                    int target = rowsum[i][j + size - 1] - (j > 0 ? rowsum[i][j - 1] : 0);
                    boolean valid = true;
                    for (int r = i + 1; r < i + size; r++) {
                        int sum = rowsum[r][j + size - 1] - (j > 0 ? rowsum[r][j - 1] : 0);
                        if (sum != target) {
                            valid = false;
                            break;
                        }
                    }
                    if (!valid) continue;
                    for (int c = j; c < j + size; c++) {
                        int sum = colsum[i + size - 1][c] - (i > 0 ? colsum[i - 1][c] : 0);
                        if (sum != target) {
                            valid = false;
                            break;
                        }
                    }
                    if (!valid) continue;
                    int d1 = 0, d2 = 0;
                    for (int k = 0; k < size; k++) {
                        d1 += grid[i + k][j + k];
                        d2 += grid[i + k][j + size - 1 - k];
                    }

                    if (d1 == target && d2 == target) {
                        return size;
                    }
                }
            }
        }
        return 1;
    }
}