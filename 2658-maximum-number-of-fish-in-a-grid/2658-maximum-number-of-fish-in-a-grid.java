class Solution {
    
    public int dfs(int[][] grid,boolean[][] vis,int i,int j,int n,int m){
        if(i < 0 || j < 0 || i >= n || j >= m || vis[i][j] || grid[i][j] == 0){
            return 0;
        }
        vis[i][j] = true;
        int fish = grid[i][j];
        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
        for(int k = 0 ; k < 4 ; k++){
            fish += dfs(grid,vis,i+directions[k][0],j+directions[k][1],n,m);
        }
        return fish;
    }
    public int findMaxFish(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int maxFish = 0;
        boolean[][] vis = new boolean[n][m];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(!vis[i][j] && grid[i][j] > 0){
                    int currentFish = dfs(grid,vis,i,j,n,m);
                    maxFish = Math.max(maxFish,currentFish);
                }
            }
        }
        return maxFish;
    }
}