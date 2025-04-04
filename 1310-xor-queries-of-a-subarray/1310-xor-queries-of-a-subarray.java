class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = queries.length;
        int[] res = new int[n];
        int m = arr.length;
        int[] prefix = new int[m];
        prefix[0] = arr[0];
        for(int i = 1 ; i < m ; i++){
            prefix[i] = prefix[i-1]^arr[i];
        }
        for(int i = 0 ; i < n ; i++){
            int l = queries[i][0];
            int r = queries[i][1];
            if(l == 0) res[i] = prefix[r];
            else res[i] = (prefix[r] ^ prefix[l - 1]);
        }
        return res;
    }
}