class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[][] dp = new int[n+1][m+1];
        for(int[] row : dp){
            Arrays.fill(row , -10000001);
        }
        // for(int i = 0 ; i < n ; i++){
        //     dp[i][0] = nums1[i]*nums2[0];
        // }
        // for(int j = 0 ; j < m ; j++){
        //     dp[0][j] = nums1[0]*nums2[j];
        // }
        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= m ; j++){
                int max = nums1[i-1] * nums2[j-1];
                if(dp[i-1][j] > max){
                    max = dp[i-1][j];
                }
                if(dp[i-1][j-1] > max){
                    max = dp[i-1][j-1];
                }
                if(dp[i][j-1] > max){
                    max = dp[i][j-1];
                }
                if(dp[i-1][j-1] + nums1[i-1] * nums2[j-1] > max){
                    max = dp[i-1][j-1] + nums1[i-1] * nums2[j-1];
                }
                dp[i][j] = max;
                // dp[i][j] = Math.max(dp[i-1][j-1],
                //                         Math.max(dp[i-1][j],
                //                                     Math.max(dp[i][j-1],
                //                                             Math.max(dp[i-1][j-1] + nums1[i-1] * nums2[j-1],nums1[i-1]*nums2[j-1])
                //                                             )
                //                                 )
                //                     );
            }
        }
        return dp[n][m];
    }
}