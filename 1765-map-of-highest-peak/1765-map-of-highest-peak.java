class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int n = isWater.length;
        int m = isWater[0].length;
        int[][] grid = new int[n][m];
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(isWater[i][j] == 1){
                    grid[i][j] = 0;
                    q.add(new int[]{i,j});
                }
                else{
                    grid[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        while(!q.isEmpty()){
            int[] currPos = q.poll();
            int i = currPos[0] , j = currPos[1];
            for(int k = 0 ; k < 4 ; k++){
                int idir = i + directions[k][0];
                int jdir = j + directions[k][1];
                if(idir >= 0 && idir < n && jdir >= 0 && jdir < m){
                    if( grid[idir][jdir] > (grid[i][j] + 1)){
                        grid[idir][jdir] = grid[i][j] + 1;
                        q.add(new int[]{idir,jdir});
                    }
                }
            }
        }
        return grid;
    }
}