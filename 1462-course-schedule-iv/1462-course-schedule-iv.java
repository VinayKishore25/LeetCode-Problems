class Solution {
    public boolean validPath(ArrayList<ArrayList<Integer>> adj, int source, int destination,int n) {
        boolean[] visited = new boolean[n];
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
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries){
        int n = prerequisites.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < numCourses ; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0 ; i < n ; i++){
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        List<Boolean> result = new ArrayList<>();
        for(int[] query : queries){
            result.add(validPath(adj,query[0],query[1],numCourses));
        }
        return result;
    }
}