class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] dp = new int[n];
        for(int i = 1 ; i < n ; i++){
            for(int j = 0 ; j < i ; j++){
                dp[i] = Math.max(dp[j] + prices[i] - prices[j],dp[i]);
            }
            dp[i] = Math.max(dp[i],dp[i-1]);
        }
        // System.out.println(Arrays.toString(dp));
        return dp[n-1];
    }
}