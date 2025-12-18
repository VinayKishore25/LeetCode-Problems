class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n = prices.length;
        long[] prefixProfit = new long[n];
        prefixProfit[0] = strategy[0] * prices[0];
        for(int i = 1 ; i < n ; i++){
            prefixProfit[i] = prefixProfit[i-1] + strategy[i] * prices[i];
        }
        long currProfit = 0;
        long maxProfit = prefixProfit[n-1];
        for(int i = 0 ; i < k ; i++){
            if(i >= k / 2){
                currProfit += prices[i];
            }
        }
        // System.out.println(Arrays.toString(prefixProfit));
        maxProfit = Math.max(maxProfit,currProfit + (prefixProfit[n-1] - prefixProfit[k - 1]));

        for(int i = k ; i < n ; i++){
            currProfit = currProfit - prices[i-k/2] + prices[i];
            // System.out.println(currProfit);
            maxProfit = Math.max(maxProfit,currProfit + (prefixProfit[n - 1] - prefixProfit[i]) + prefixProfit[i - k]);
            
        }

        return maxProfit;
    }
}