class Solution {
    public int minScore(int n, int[][] roads) {
        List<List<Pair>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            adj.get(road[0]).add(new Pair(road[1], road[2]));
            adj.get(road[1]).add(new Pair(road[0], road[2]));
        }

        int[] bestFit = new int[n + 1];
        Arrays.fill(bestFit, Integer.MAX_VALUE);

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(1, Integer.MAX_VALUE));

        int result = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            Pair current = q.poll();

            int node = current.v;
            int minWeight = current.weight;

            if (node == n) {
                result = Math.min(result, minWeight);
            }

            for (Pair neighbour : adj.get(node)) {
                int currentMinimum = Math.min(minWeight, neighbour.weight);

                if (currentMinimum < bestFit[neighbour.v]) {
                    bestFit[neighbour.v] = currentMinimum;
                    q.offer(new Pair(neighbour.v, currentMinimum));
                }
            }
        }

        return result;
    }
}

class Pair {
    int v;
    int weight;

    public Pair(int v, int weight) {
        this.v = v;
        this.weight = weight;
    }
}