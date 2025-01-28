class Solution {
    int maxFish = 0;
    public void dfs(int[][] grid,boolean[][] vis,int i,int j, int n,int m,int[] currentFish){
        if(i < 0 || j < 0 || i >= n || j >= m || vis[i][j] || grid[i][j] == 0){
            return;
        }
        vis[i][j] = true;
        currentFish[0]+=grid[i][j];
        maxFish = Math.max(maxFish,currentFish[0]);
        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
        for(int k = 0 ; k < 4 ; k++){
            dfs(grid,vis,i+directions[k][0],j+directions[k][1],n,m,currentFish);
        }

    }
    public int findMaxFish(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(!vis[i][j] && grid[i][j] > 0){
                    dfs(grid,vis,i,j,n,m,new int[1]);
                }
            }
        }
        return maxFish;
    }
}