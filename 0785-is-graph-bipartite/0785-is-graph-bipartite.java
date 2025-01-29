class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] visited = new int[n+1];
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0 ; i < n ; i++){
            if(visited[i] == 0){
                q.add(new int[]{i,1});
                visited[i] = 1;
                while(!q.isEmpty()){
                    int[] root = q.poll();
                    int node = root[0];
                    int currentColor = root[1];
                    for(int neighbour : graph[node]){
                        if(visited[neighbour] == 0){
                            int color = currentColor == 1 ? 2 : 1;
                            q.offer(new int[]{neighbour,color});
                            visited[neighbour] = color;
                        }
                        else if(visited[neighbour] == currentColor){
                            return false;
                        }
                    } 
                }
            }
        }
        return true;
    }
}