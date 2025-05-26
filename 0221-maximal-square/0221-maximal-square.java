class Solution {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int min = 0;
        int[][] dp = new int[n][m];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                dp[i][j] = matrix[i][j] - '0';
                if(dp[i][j] == 1){
                    min = 1;
                }
            }
        }
        
        for(int i = 1 ; i < n ; i++){
            for(int j = 1 ; j  < m ; j++){
                if(dp[i-1][j] != 0 && dp[i][j-1] != 0 && dp[i-1][j-1] != 0 && dp[i][j] != 0){
                    dp[i][j] = Math.min(dp[i-1][j],Math.min(dp[i-1][j-1],dp[i][j-1])) + 1;
                    min = Math.max(min,dp[i][j]);
                }
            }
        }

        
        return min * min;
    }
}