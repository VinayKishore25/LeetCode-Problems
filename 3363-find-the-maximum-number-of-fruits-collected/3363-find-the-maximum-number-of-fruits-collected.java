class Solution {
    public int dfs1(int i,int j,int[][] grid,int n,int[][] dp){
        if(i >= n || i < 0 || j >= n || j < 0) return 0;
         if (i == j || i > j) {
            return 0;
        }
        if(i == n - 1 && j == n - 1){
            return 0;
        }
        if(dp[i][j] != -1) return dp[i][j];
        int score = grid[i][j];
        int left = score + dfs1(i+1,j-1,grid,n,dp);
        int down = score + dfs1(i+1,j,grid,n,dp);
        int right = score + dfs1(i+1,j+1,grid,n,dp);
        return dp[i][j] = Math.max(left,Math.max(down,right));
    }
    public int dfs2(int i,int j,int[][] grid,int n,int[][] dp){
        if(i >= n || i < 0 || j >= n || j < 0) return 0;
         if ( i == j || j > i) {
            return 0;
        }
        if(i == n - 1 && j == n - 1){
            return 0;
        }
        if(dp[i][j] != -1) return dp[i][j];
        int score = grid[i][j];
        int left = score + dfs2(i-1,j+1,grid,n,dp);
        int down = score + dfs2(i,j+1,grid,n,dp);
        int right = score + dfs2(i+1,j+1,grid,n,dp);
        return dp[i][j] = Math.max(left,Math.max(down,right));
    }
    public int maxCollectedFruits(int[][] fruits) {
        int n = fruits.length;
        int r1 = 0;
        int[][] dp = new int[n][n];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        for(int i = 0 ; i < n ; i++){
            r1 += fruits[i][i];
            fruits[i][i] = 0;
            dp[i][i] = 0;
        }

        int r2 = dfs1(0,n-1,fruits,n,dp);
        int r3 = dfs2(n-1,0,fruits,n,dp);
        return r1 + r2 + r3;
    }
}