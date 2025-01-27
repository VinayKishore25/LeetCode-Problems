class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = prerequisites.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        boolean[] visited = new boolean[numCourses];
        int[] indegree = new int[numCourses];
        for(int i = 0 ; i < numCourses ; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0 ; i < n ; i++){
            // adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses ; i++){
            if(indegree[i] == 0){
                q.add(i);
                // numCourses--;
            }
        }
        while(!q.isEmpty()){
            int course = q.poll();
            numCourses--;
            for(int neighbour : adj.get(course)){
                indegree[neighbour]--;
                if(indegree[neighbour] == 0){
                    q.add(neighbour);
                }
            }
        }
        return numCourses == 0;
    }
}