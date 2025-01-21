class Solution {
    public long gridGame(int[][] grid) {
        long result = Long.MAX_VALUE;
        int n = grid[0].length;
        long[] prefix1 = new long[n];
        long[] prefix2 = new long[n];
        prefix1[0] = grid[0][0];
        prefix2[0] = grid[1][0];
        for(int i = 1 ; i < n ; i++){
            prefix1[i] = prefix1[i-1] + grid[0][i];
            prefix2[i] = prefix2[i-1] + grid[1][i];
        }
        for(int i = 0 ; i < n ; i++){
            long topSum = prefix1[n - 1] - prefix1[i];
            long bottomSum = 0;
            if(i != 0){
                bottomSum = prefix2[i - 1];
            }
            result = Math.min(result,Math.max(topSum,bottomSum));
        }
        return result;
    }
}