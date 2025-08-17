class Solution {
    public double new21Game(int n, int k, int maxPts) {
        if (k == 0 || n >= k + maxPts) return 1.0;
        double[] dp = new double[k + maxPts]; 
        dp[0] = 1.0;
        double sum = dp[0];
        for (int i = 1; i < k + maxPts; i++) {
            dp[i] = sum / maxPts;
            if (i < k) {
                sum += dp[i];
            }
            if (i >= maxPts) {
                sum -= dp[i - maxPts];
            }
        }
        double res = 0.0;
        for (int i = k; i <= n; i++) res += dp[i];
        return res;
    }
}