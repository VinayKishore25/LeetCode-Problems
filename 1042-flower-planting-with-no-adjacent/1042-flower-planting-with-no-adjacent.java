class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i <  n ; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0 ; i < paths.length ; i++){
            adj.get(paths[i][0] - 1).add(paths[i][1] - 1);
            adj.get(paths[i][1] - 1).add(paths[i][0] - 1);
        }
        int[] colors = new int[n];
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n ; i++){
            if(colors[i] == 0){
                q.add(i);
                colors[i] = 1;
                while(!q.isEmpty()){
                    int node = q.poll();
                    int color = colors[node];
                    for(int neighbour : adj.get(node)){
                        if(colors[neighbour] == 0 || colors[neighbour] == color){
                            int curColor = color == 4 ? 1 : color + 1;
                            colors[neighbour] = curColor;
                            q.offer(neighbour);
                        }
                    }
                }
            }
        }
        return colors;
    }
}