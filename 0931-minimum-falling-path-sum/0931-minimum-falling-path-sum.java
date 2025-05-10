class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        int minValue = Integer.MAX_VALUE;
        for(int[] row : dp){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        for(int i = 0 ; i < m ; i++){
            if(n == 1){
                minValue = Math.min(minValue,matrix[0][i]);
            }
            dp[0][i] = matrix[0][i];
        }
        for(int i = 1 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(j - 1 >= 0){
                    dp[i][j] = Math.min(dp[i][j],dp[i-1][j-1]+matrix[i][j]);
                }
                if(j + 1 < m){
                    dp[i][j] = Math.min(dp[i][j],dp[i-1][j+1]+matrix[i][j]);
                }
                dp[i][j] = Math.min(dp[i][j],dp[i-1][j]+matrix[i][j]);
                if(i == n - 1){
                    // System.out.println(dp[i][j] + " " + i + " " +j);
                    minValue = Math.min(minValue,dp[i][j]);
                }
            }
        }
        // System.out.println(Arrays.deepToString(dp));
        return minValue;
    }
}