class Solution {
    int maxCycle = -1;
    int maxChain = 0;
    public void solve(boolean[] visited,ArrayList<ArrayList<Integer>> adj,int chain,int node,boolean[] currentVisited,int[] prevLocation){
        visited[node] = true;
        currentVisited[node] = true;
        prevLocation[node] = chain;
        for(int neighbour : adj.get(node)){
            if(!visited[neighbour]){
                solve(visited,adj,chain+1,neighbour,currentVisited,prevLocation);
            }
            else if(currentVisited[neighbour]){
                int currentLength = chain - prevLocation[neighbour] + 1;
                maxCycle = Math.max(maxCycle,currentLength);
            }
        }
        currentVisited[node] = false;
    }
    public int maximumInvitations(int[] favorite) {
        int n = favorite.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n ; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < n ; i++){
            adj.get(i).add(favorite[i]);
        }
        int maxLength = maxCycleLength(adj,n);
        int chainLength = topologicalSort(favorite,n);
        return Math.max(maxLength,chainLength);
    }
    public int maxCycleLength(ArrayList<ArrayList<Integer>> adj,int n){
        boolean[] visited = new boolean[n];
        boolean[] currentVisited = new boolean[n]; 
        int[] prevLocation = new int[n];
        for(int i = 0 ; i < n ; i++){
            if(!visited[i]){
                solve(visited,adj,0,i,currentVisited,prevLocation);
            }
        }
        return maxCycle;
    }
    public int topologicalSort(int[] favorite,int n){
        int[] indegree = new int[n];
        for(int i = 0 ; i < n ; i++){
            indegree[favorite[i]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0 ; i < n ; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }
        int[] distance = new int[n];
        Arrays.fill(distance,1);
        while(!q.isEmpty()){
            int node = q.poll();
            int currentFavorite = favorite[node];
            distance[currentFavorite] = Math.max(distance[currentFavorite],distance[node] + 1);
            indegree[currentFavorite]--;
            if(indegree[currentFavorite] == 0){
                q.add(currentFavorite);
            }
        }

        for(int i = 0 ; i < n ; i++){
            if(favorite[favorite[i]] == i){
                maxChain += distance[i];
            }
        }
        return maxChain;
    }
}