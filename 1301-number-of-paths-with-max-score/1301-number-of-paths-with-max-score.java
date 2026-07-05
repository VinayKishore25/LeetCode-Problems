class Solution {
    public int[] pathsWithMaxScore(List<String> board) {

        int mod = 1_000_000_007;
        int n = board.size();
        int[][] grid = new int[n][n];
        int[][] directions = {{ -1, 0 }, { 0, -1 },{ -1, -1 }};
        long[][] dp = new long[n+1][n+1];
        int[][] ways = new int[n+1][n+1];
        for(int i = 0 ; i < n ; i++){
            dp[i][n] = Integer.MIN_VALUE;
            dp[n][i] = Integer.MIN_VALUE;
        }
        dp[n][n] = 0;
        ways[n][n] = 1;



        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                char ch = board.get(i).charAt(j);
                if((i == 0 && j == 0) || (i == n - 1 && j == n - 1)){
                    grid[i][j] = 0;
                }
                else if(ch == 'X'){
                    grid[i][j] = -1;
                    dp[i][j] = Integer.MIN_VALUE;
                }
                else{
                    grid[i][j] = ch - '0';
                }
            }
        }
        

        for(int i = n - 1 ; i >= 0 ; i--){
            for(int j = n - 1 ; j >= 0 ; j--){
                long maxNeighbour = Math.max(dp[i+1][j], Math.max(dp[i][j+1], dp[i+1][j+1]));
                if(grid[i][j] == -1) continue;
                dp[i][j] = (maxNeighbour + grid[i][j]) % mod;

                if(maxNeighbour < 0) continue;
                if(dp[i][j + 1] == maxNeighbour ){
                    ways[i][j] = (ways[i][j] + ways[i][j + 1])%mod;
                }
                if(dp[i + 1][j + 1] == maxNeighbour ){
                    ways[i][j] = (ways[i][j] + ways[i + 1][j + 1])%mod;
                }
                if(dp[i + 1][j] == maxNeighbour ){
                    ways[i][j] = (ways[i][j] + ways[i + 1][j])%mod;
                }

            }
        }
        dp[0][0] = dp[0][0] < 0 ? 0 : dp[0][0];
        return new int[]{(int)dp[0][0], ways[0][0]};

    }
}