class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] dp = new int[n][m];
        dp[0][0] = 1;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m; j++){
                if(i == 0 || j == 0){
                    if(obstacleGrid[i][j] == 0){
                        if(j != 0){
                            dp[i][j] = dp[i][j-1];
                        }
                        else if(i != 0){
                            dp[i][j] = dp[i-1][j];
                        }
                    }
                    else{
                        dp[i][j] = 0;
                    }
                }
                else{
                    if(obstacleGrid[i][j] == 0){
                        dp[i][j] = dp[i-1][j] + dp[i][j-1];
                    }
                    else{
                        dp[i][j] = 0;
                    }
                }
            }
        }
        return dp[n-1][m-1];
    }
}