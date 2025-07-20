class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][][] dp = new int[n][m][m];
        for(int j1 = 0 ; j1 < m ; j1++){
            for(int j2 = 0 ; j2 < m ; j2++){
                if(j1 == j2){
                    dp[n-1][j1][j2] = grid[n-1][j1];
                }
                else{
                    dp[n-1][j1][j2] = grid[n-1][j1] + grid[n-1][j2];
                }
            }
        }
        int[] directions = {-1,0,1};
        for(int i = n - 2 ; i >= 0 ; i--){
            for(int j1 = 0 ; j1 < m ; j1++){
                for(int j2 = 0 ; j2 < m ; j2++){
                    int value = 0;
                    int maxi = 0;
                    if(j1 == j2) value = grid[i][j1];
                    else value = grid[i][j1] + grid[i][j2];
                    if(j1 + 1 < m){
                        if(j2 + 1 < m)
                        maxi = Math.max(maxi,value + dp[i+1][j1+1][j2+1]);
                        if(j2 - 1 >= 0)
                        maxi = Math.max(maxi,value + dp[i+1][j1+1][j2-1]);
                        maxi = Math.max(maxi,value + dp[i+1][j1+1][j2]);
                    }
                    if(j2 + 1 < m)
                    maxi = Math.max(maxi,value + dp[i+1][j1][j2+1]);
                    if(j2 - 1 >= 0)
                    maxi = Math.max(maxi,value + dp[i+1][j1][j2-1]);
                    maxi = Math.max(maxi,value + dp[i+1][j1][j2]);
                    if(j1 - 1 >= 0 ){
                        if(j2 + 1 < m)
                        maxi = Math.max(maxi,value + dp[i+1][j1-1][j2+1]);
                        if(j2 - 1 >= 0)
                        maxi = Math.max(maxi,value + dp[i+1][j1-1][j2-1]);
                        maxi = Math.max(maxi,value + dp[i+1][j1-1][j2]);
                    }
                    dp[i][j1][j2] = maxi;
                }
            }
        }
        int result = 0;
        for(int j1 = 0 ; j1 < m ; j1++){
            for(int j2 = 0 ; j2 < m ; j2++){
                result = Math.max(result,dp[0][j1][j2]);
            }
        }
        return result;
    }
}