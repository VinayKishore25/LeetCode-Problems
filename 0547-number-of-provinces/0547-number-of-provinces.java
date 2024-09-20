class Solution {
    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> adj = new ArrayList<>();
        int n = isConnected.length;
        for(int i = 0 ;i < n ; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(i != j && isConnected[i][j] == 1){
                    adj.get(i).add(j);
                }
            }
        }
        int count = 0;
        boolean[] vis = new boolean[n];
        for(int i = 0 ; i < n ; i++){
            if(!vis[i]){
                count++;
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                while(!q.isEmpty()){
                    int x = q.poll();
                    for(int each : adj.get(x)){
                        if(!vis[each]){
                            vis[each] = true;
                            q.add(each);
                        }
                    }
                }
            }
        }
        return count;
    }
}