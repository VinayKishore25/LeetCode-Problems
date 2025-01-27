class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
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
        // List<Integer> al = new ArrayList<>();
        for(int i = 0 ; i < numCourses ; i++){
            if(indegree[i] == 0) {
                q.add(i);
            }
        }
        int[] result = new int[numCourses];
        int j = 0;
        while(!q.isEmpty()){
            int x = q.poll();
            result[j++] = x;
            for(int each : adj.get(x)){
                indegree[each]--;
                if(indegree[each] == 0){
                    q.add(each);
                }
            }
        }
        if (j != numCourses) {
            return new int[0];
        }
        return result;
    }
}