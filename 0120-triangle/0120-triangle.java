class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int l = (n * (n + 1))/2;
        int[] dp = new int[l];
        for(int i = 0 ; i < n ; i++){
            dp[i] = triangle.get(n-1).get(i);
        }
        int iter = n;
        for(int i = n - 2 ; i >= 0 ; i--){
            for(int j = 0 ; j <= i ; j++){
                int justBelow = triangle.get(i + 1).get(j);
                int nextBelow = triangle.get(i + 1).get(j+1);
                dp[iter] = triangle.get(i).get(j) + Math.min(dp[iter - i - 1],dp[iter - i - 2]);
                iter++;
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[l-1];
    }
}