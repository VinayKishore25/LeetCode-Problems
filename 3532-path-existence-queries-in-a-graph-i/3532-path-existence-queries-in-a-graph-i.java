class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int[] connectedComponents = new int[n];
        boolean[] result = new boolean[queries.length];
        for(int i = 1 ; i < n ; i++){
            if(nums[i] - nums[i - 1] <= maxDiff){
                connectedComponents[i] = connectedComponents[i - 1];
            }
            else{
                connectedComponents[i] = connectedComponents[i - 1] + 1;
            }
        }
        int i = 0;
        for(int[] query : queries){
            int u = query[0];
            int v = query[1];
            result[i++] = (connectedComponents[u] == connectedComponents[v]);
        }
        return result;
    }
}