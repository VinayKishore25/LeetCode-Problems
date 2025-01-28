class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public void dfs(int[][] graph,int node,List<Integer> al,boolean[] visited,int n){
        if(visited[node]) return;
        if(node == n-1){
            al.add(n-1);
            ans.add(new ArrayList<>(al));
            al.remove(al.size()-1);
            return;
        }
        for(int neighbour : graph[node]){
            visited[node] = true;
            al.add(node);
            dfs(graph,neighbour,al,visited,n);
            visited[node] = false;
            al.remove(al.size()-1);
        }
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        for(int neighbour : graph[0]){
            List<Integer> al = new ArrayList<>();
            boolean[] visited = new boolean[n];
            visited[0] = true;
            al.add(0);
            dfs(graph,neighbour,al,visited,n);
        }
        return ans;
    }
}