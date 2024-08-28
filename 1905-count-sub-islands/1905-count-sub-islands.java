class Solution {
    public boolean isSubIsland(int[][] grid,List<List<Integer>> island){
        int n = island.size();
        for(int i = 0 ; i < n ; i++){
            if(grid[island.get(i).get(0)][island.get(i).get(1)] == 0) return false;
        }
        return true;
    }
    public void solve(int[][] grid,int i,int j,boolean[][] vis,int n,int m,List<List<Integer>> island){
        if(i < 0 || j < 0 || i >= n || j >= m || vis[i][j] || grid[i][j] == 0) return;
        vis[i][j] = true;
        List<Integer> a = new ArrayList<>();
        a.add(i);
        a.add(j);
        island.add(a);
        solve(grid,i+1,j,vis,n,m,island);
        solve(grid,i-1,j,vis,n,m,island);
        solve(grid,i,j+1,vis,n,m,island);
        solve(grid,i,j-1,vis,n,m,island);
    }
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int n = grid1.length;
        int m = grid2[0].length;
        int count = 0;
        boolean[][] vis = new boolean[n][m];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid2[i][j] == 1 && !vis[i][j]){
                    List<List<Integer>> island = new ArrayList<>();
                    solve(grid2,i,j,vis,n,m,island);
                    if(isSubIsland(grid1,island)){
                        count++;
                    }
                }
            }
        }
        return count;
    }
}