class Solution {

    public int minCost(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];
        int[][][] dp = new int[n][m][1024];
        for(int[][] matrix : dp){
            for(int[] row : matrix){
                Arrays.fill(row, -1);
            }
        }

        return dfs(grid, 0, 0, 0, visited, dp);
    }

    private int dfs(int[][] grid, int r, int c, int currentXOR, boolean[][] visited, int[][][] dp) {

        int n = grid.length;
        int m = grid[0].length;

        currentXOR ^= grid[r][c];

        if (r == n - 1 && c == m - 1) {
            return currentXOR;
        }

        if(dp[r][c][currentXOR] != -1){
            return dp[r][c][currentXOR];
        }
        visited[r][c] = true;

        int minimumXOR = Integer.MAX_VALUE;

        int[][] directions = {{1, 0}, {0, 1}};

        for (int[] d : directions) {
            int nr = r + d[0];
            int nc = c + d[1];

            if (nr < n && nc < m && !visited[nr][nc]) {

                int result = dfs(
                    grid, nr, nc, currentXOR, visited, dp
                );

                minimumXOR = Math.min(minimumXOR, result);
            }
        }
        visited[r][c] = false;

        return dp[r][c][currentXOR] = minimumXOR;
    }
}