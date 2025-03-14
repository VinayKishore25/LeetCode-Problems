class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] dp = new int[n];
        dp[0] = 0;
        int max = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j <= i ; j++){
                dp[i] = Math.max(dp[i],prices[i] - prices[j]);
            }
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}