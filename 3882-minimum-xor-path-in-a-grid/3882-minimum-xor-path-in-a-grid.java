class Solution {

    public int minCost(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][][] dp = new int[n][m][1024];

        for (int[][] matrix : dp) {
            for (int[] row : matrix) {
                Arrays.fill(row, -1);
            }
        }

        return dfs(grid, 0, 0, 0, dp);
    }

    private int dfs(int[][] grid, int r, int c,
                    int currentXOR, int[][][] dp) {

        int n = grid.length;
        int m = grid[0].length;

        currentXOR ^= grid[r][c];

        if (r == n - 1 && c == m - 1) {
            return currentXOR;
        }

        if (dp[r][c][currentXOR] != -1) {
            return dp[r][c][currentXOR];
        }

        int minimumXOR = Integer.MAX_VALUE;

        if (r + 1 < n) {
            minimumXOR = Math.min(
                minimumXOR,
                dfs(grid, r + 1, c, currentXOR, dp)
            );
        }

        if (c + 1 < m) {
            minimumXOR = Math.min(
                minimumXOR,
                dfs(grid, r, c + 1, currentXOR, dp)
            );
        }

        return dp[r][c][currentXOR] = minimumXOR;
    }
}
