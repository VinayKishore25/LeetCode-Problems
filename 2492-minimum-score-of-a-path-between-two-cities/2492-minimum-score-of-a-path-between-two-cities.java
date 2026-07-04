class Solution {
    public int minScore(int n, int[][] roads) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0 ; i <= n ; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] road : roads){
            adj.get(road[0]).add(new Pair(road[1],road[2]));
            adj.get(road[1]).add(new Pair(road[0],road[2]));
        }
        int[] bestFit = new int[n+1];
        Arrays.fill(bestFit,Integer.MAX_VALUE);
        Queue<Triplet> q = new LinkedList<>();
        q.add(new Triplet(1,0,Integer.MAX_VALUE));
        int result = Integer.MAX_VALUE;
        while(!q.isEmpty()){
            Triplet parent = q.poll();
            int node = parent.v;
            long cost = parent.cost;
            int minWeight = parent.minWeightOfThePath;
            // System.out.println(node);
            // System.out.println(Arrays.toString(bestFit));
            if(node == n){
                result = Math.min(result,minWeight);
            }
            for(Pair neighbour : adj.get(node)){
                long currentCost = cost + neighbour.weight;
                int currentMinimum = Math.min(minWeight,neighbour.weight);
                if (currentMinimum < bestFit[neighbour.v]) {
                    bestFit[neighbour.v] = currentMinimum;
                    q.offer(new Triplet(neighbour.v, currentCost, currentMinimum));
                }
            }
        }
        return result;
    }
}
class Pair{
    int v;
    int weight;
    public Pair(int v, int weight){
        this.v = v;
        this.weight = weight;
    }
}
class Triplet{
    int v;
    long cost;
    int minWeightOfThePath;
    public Triplet(int v,long cost,int minWeightOfThePath){
        this.v = v;
        this.cost = cost;
        this.minWeightOfThePath = minWeightOfThePath;
    }
}