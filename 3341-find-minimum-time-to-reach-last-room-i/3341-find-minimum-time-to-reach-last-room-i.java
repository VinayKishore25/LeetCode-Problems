class Solution {
    public int minTimeToReach(int[][] moveTime) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.cost - b.cost);
        int n = moveTime.length;
        int m = moveTime[0].length;
        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
        int[][] minCost = new int[n][m];
        for (int[] row : minCost) Arrays.fill(row, Integer.MAX_VALUE);
        pq.add(new Pair(0,0,0));
        moveTime[0][0] = 0;
        while(!pq.isEmpty()){
            Pair pair = pq.poll();
            int cr = pair.row;
            int cc = pair.col;
            int cost = pair.cost;
            if (cost >= minCost[cr][cc]) continue;
            if (cr == n - 1 && cc == m - 1) return cost;
            minCost[cr][cc] = cost;
            for(int i = 0 ; i < 4 ; i++){
                int nr = cr + directions[i][0];
                int nc = cc + directions[i][1];
                if(nr >= 0 && nr < n && nc >=  0 && nc < m && minCost[nr][nc] == Integer.MAX_VALUE) {
                    int nextTime = Math.max(moveTime[nr][nc], cost) + 1;
                    pq.add(new Pair( nr, nc,nextTime));
                }
            }
        }
        return -1;
    }
}
class Pair{
    int row;
    int col;
    int cost;
    Pair(int row,int col,int cost){
        this.row = row;
        this.col = col;
        this.cost = cost;
    }
}