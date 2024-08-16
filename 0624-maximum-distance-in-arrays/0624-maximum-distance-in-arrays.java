class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int n = arrays.size();
        int ans = 0;
        int prevLow = arrays.get(0).get(0);
        int prevHigh = arrays.get(0).get(arrays.get(0).size() - 1);
        for(int i = 1 ; i < n ; i++){
            int m = arrays.get(i).size();
            int res1 = Math.abs(arrays.get(i).get(0) - prevHigh);
            int res2 = Math.abs(arrays.get(i).get(m - 1) - prevLow); 
            ans = Math.max(ans,Math.max(res1,res2));
            prevLow = Math.min(prevLow,arrays.get(i).get(0));
            prevHigh = Math.max(prevHigh,arrays.get(i).get(m-1));
        }
        return ans;
    }
}