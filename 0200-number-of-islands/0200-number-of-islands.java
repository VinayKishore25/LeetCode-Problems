class Solution {
    int count = 0;
    public void solve(char[][] grid , int i , int j , boolean[][] vis , int n, int m)
    {
        if(i < 0 || j < 0 || i >= n || j >= m || vis[i][j] || grid[i][j] == '0')
        return;
        vis[i][j] = true;
        solve(grid,i+1,j,vis,n,m);
        solve(grid,i-1,j,vis,n,m);
        solve(grid,i,j+1,vis,n,m);
        solve(grid,i,j-1,vis,n,m);
    }
    public int numIslands(char[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(!vis[i][j] && grid[i][j] == '1')
                {
                    solve(grid,i,j,vis,n,m);
                    count++;
                }
            }
        }
        return count;
    }
}