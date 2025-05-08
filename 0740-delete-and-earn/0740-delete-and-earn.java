class Solution {
    public int deleteAndEarn(int[] nums) {
        int n = nums.length;
        int m = 0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int num : nums){
            m = Math.max(m,num);
            hm.put(num,hm.getOrDefault(num,0) + 1);
        }
        long[] dp = new long[m+1];
        dp[1] = hm.getOrDefault(1,0);
        for(int i = 2 ; i <= m ; i++){
            dp[i] = Math.max((i * hm.getOrDefault(i,0)) + dp[i-2],dp[i-1]);
        }
        return 
        (int)dp[m];
    }
}