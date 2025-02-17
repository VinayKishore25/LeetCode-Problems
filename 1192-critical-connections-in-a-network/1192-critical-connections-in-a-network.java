class Solution {
    int timer = 1;
    public void dfs(int node,int parent,List<List<Integer>> adj,int[] time,int[] low,boolean[] visited,List<List<Integer>> criticalConnection){
        visited[node] = true;
        time[node] = low[node] = timer;
        timer++;
        for(int neighbour : adj.get(node)){
            if(neighbour == parent) continue;
            if(!visited[neighbour]){
                dfs(neighbour,node,adj,time,low,visited,criticalConnection);
                low[node] = Math.min(low[node],low[neighbour]);
                if(low[neighbour] > time[node]){
                    List<Integer> bridge = new ArrayList<>();
                    bridge.add(neighbour);
                    bridge.add(node);
                    criticalConnection.add(new ArrayList<>(bridge));
                }
            }
            else{
                low[node] = Math.min(low[node],low[neighbour]);
            }
        }
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0 ; i < connections.size() ; i++){
            adj.get(connections.get(i).get(0)).add(connections.get(i).get(1));
            adj.get(connections.get(i).get(1)).add(connections.get(i).get(0));
        }
        boolean[] visited = new boolean[n];
        int[] time = new int[n];
        int[] low = new int[n];
        List<List<Integer>> criticalConnection = new ArrayList<>();
        dfs(0,-1,adj,time,low,visited,criticalConnection);
        return criticalConnection;
    }
}