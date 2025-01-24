class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> safe = new ArrayList<>();
        int n = graph.length;
        int[] condition = new int[n];
        for(int i = 0; i < n ; i++){
            if(isSafe(graph,i,condition)){
                safe.add(i);
            }
        }
        return safe;
    }
    public boolean isSafe(int[][] graph, int node, int[] condition){
        if(condition[node] == 1) return false;
        if(condition[node] == 2) return true;
        condition[node] = 1;
        for(int child : graph[node]){
            if(!isSafe(graph,child,condition)){
                return false;
            }
        }
        condition[node] = 2;
        return true;
    }
}