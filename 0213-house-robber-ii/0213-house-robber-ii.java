class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];
        int[] memo = new int[n+1];
        dp[0] = 0;
        dp[1] = 0;
        if(n == 1) return nums[0];
        for(int i = 2 ; i < n + 1  ; i++){
            dp[i] = Math.max(nums[i-2]+dp[i-2],dp[i-1]);
        }
        memo[0] = 0;
        memo[1] = 0;
        int j = 1;
        for(int i = 2 ; i < n + 1  ; i++){
            memo[i] = Math.max(nums[j++]+memo[i-2],memo[i-1]);
        }
        return Math.max(dp[n],memo[n]);
    }
}