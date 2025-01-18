class Solution {
    public int minCost(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] cost = new int[n][m];
        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
        for(int[] row : cost){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        cost[0][0] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0,0});
        while(!q.isEmpty()){
            int[] currPos = q.poll();
            int i = currPos[0] , j = currPos[1] , currCost = currPos[2];
            for(int k = 0 ; k < 4 ; k++){
                int iDir = i + directions[k][0];
                int jDir = j + directions[k][1];
                if(iDir >= 0 && jDir >= 0 && iDir < n && jDir < m){
                    int newCost = currCost;
                    if(grid[i][j] != k + 1){
                        newCost++;
                    }
                    if(newCost < cost[iDir][jDir]){
                        cost[iDir][jDir] = newCost;
                        q.add(new int[]{iDir,jDir,newCost});
                    }
                }
            }
        }
        return cost[n-1][m-1];
    }
}