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

        boolean[] visited = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();

        q.offer(1);
        visited[1] = true;

        int ans = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            int node = q.poll();

            for (Pair neighbour : adj.get(node)) {
                ans = Math.min(ans, neighbour.weight);

                if (!visited[neighbour.v]) {
                    visited[neighbour.v] = true;
                    q.offer(neighbour.v);
                }
            }
        }

        return ans;
    }
}

class Pair {
    int v;
    int weight;

    Pair(int v, int weight) {
        this.v = v;
        this.weight = weight;
    }
}