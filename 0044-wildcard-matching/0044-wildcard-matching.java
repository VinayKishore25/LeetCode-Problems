class Solution {
    // public int f(int i,int j,String s,String p,int[][] dp){
    //     if(j < 0){
    //         return i < 0 ? 1 : 0;
    //     }
    //     if(i < 0){
    //         for(int k = 0 ; k <= j ; k++){
    //             if(p.charAt(k) != '*') return 0;
    //         }
    //         return 1;
    //     }
    //     if(dp[i][j] != -1) return dp[i][j];
    //     if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?'){
    //         return dp[i][j] = f(i-1,j-1,s,p,dp) ;
    //     }
    //     if(p.charAt(j) == '*'){
    //         int val1 = f(i,j-1,s,p,dp);
    //         int val2 = f(i-1,j,s,p,dp);
    //         if(val1 == 1 || val2 == 1){
    //             return dp[i][j] = 1;
    //         }
    //         return dp[i][j] = 0;
    //     }
    //     return 0;
    // }
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[][] dp = new boolean[n+1][m+1];
        dp[0][0] = true;
        for(int j = 1 ; j <= m ; j++){
            boolean flag = true;
            for(int k = 1 ; k <= j ; k++){
                if(p.charAt(k - 1) != '*'){
                    flag = false;
                    break;
                }
            }
            dp[0][j] = flag;
        }
        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= m ; j++){
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?'){
                    dp[i][j] = dp[i-1][j-1];
                }
                else if(p.charAt(j-1) == '*'){
                    dp[i][j] = dp[i][j-1] || dp[i-1][j];
                }
            }
        }

        return dp[n][m];
    }
}