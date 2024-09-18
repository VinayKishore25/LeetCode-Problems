class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int n = prerequisites.length;
        int[] indegree = new int[numCourses];
        for(int i = 0 ; i < numCourses ; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0 ; i < n ; i++){
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[numCourses];
        int count = 0;
        for(int i = 0 ; i < numCourses ; i++){
            if(indegree[i] == 0) {
                q.add(i);
                vis[i] = true;
            }
        }
        while(!q.isEmpty()){
            int x = q.poll();
            // System.out.println(x + " array " + adj.get(x));
            count++;
            for(int each : adj.get(x)){
                indegree[each]--;
                if(indegree[each] == 0){
                    q.add(each);
                }
            }
        }
        return count == numCourses;
    }
}