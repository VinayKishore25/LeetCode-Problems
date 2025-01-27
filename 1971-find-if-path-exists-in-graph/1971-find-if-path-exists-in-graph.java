class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        boolean[] visited = new boolean[n];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        q.offer(source);
        visited[source] = true;
        while(!q.isEmpty()){
            int node = q.poll();
            for(int neighbour: adj.get(node)){
                if(visited[neighbour]){
                    continue;
                }
                else{
                    if(neighbour == destination) return true;
                    q.add(neighbour);
                    visited[neighbour] = true;
                }
            }
        }
        return source == destination;
    }
}