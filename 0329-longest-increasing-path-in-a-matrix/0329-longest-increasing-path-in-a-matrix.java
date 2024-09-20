class Solution {
    public int solve(int[][] matrix,int i,int j,int n,int m,int prev,int[][] dp){
        if(i < 0 || j < 0 || i >= n || j >= m || (matrix[i][j] <= prev)){
            return 0;
        }
        if(dp[i][j] != -1) return dp[i][j];
        int up = 1 + solve(matrix,i+1,j,n,m,matrix[i][j],dp);
        int down = 1 + solve(matrix,i-1,j,n,m,matrix[i][j],dp);
        int left = 1 + solve(matrix,i,j-1,n,m,matrix[i][j],dp);
        int right = 1 + solve(matrix,i,j+1,n,m,matrix[i][j],dp);
        return dp[i][j] = Math.max(up,Math.max(down,Math.max(left,right)));
    }
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int ans = Integer.MIN_VALUE;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                int[][] dp = new int[n][m];
                for(int[] dp1 : dp){
                    for(int k = 0 ; k < m ; k++){
                        dp1[k] = -1;
                    }
                }
                int res = solve(matrix,i,j,n,m,-1,dp);
                ans = Math.max(ans,res);
            }
        }
        return ans;
    }
}