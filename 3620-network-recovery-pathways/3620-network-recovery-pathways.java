class Solution {
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        List<List<Pair>> adj = new ArrayList<>();
        int n = online.length;
        int maxWeight = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            if (online[edge[0]] && online[edge[1]]) {
                adj.get(edge[0]).add(new Pair(edge[1], edge[2]));
                maxWeight = Math.max(maxWeight, edge[2]);
            }
        }

        int minWeight = 0;
        int ans = -1;

        while (minWeight <= maxWeight) {
            int mid = minWeight + (maxWeight - minWeight) / 2;

            if (dijkstra(adj, mid, k, n)) {
                ans = mid;
                minWeight = mid + 1;
            } else {
                maxWeight = mid - 1;
            }
        }

        return ans;
    }

    public boolean dijkstra(List<List<Pair>> adj, int midWeight, long k, int n) {

        PriorityQueue<SecondPair> q =
                new PriorityQueue<>((a, b) -> Long.compare(a.cost, b.cost));

        long[] bestFit = new long[n];
        Arrays.fill(bestFit, Long.MAX_VALUE);

        bestFit[0] = 0;
        q.add(new SecondPair(0, 0));

        while (!q.isEmpty()) {

            SecondPair parent = q.poll();

            int node = parent.v;
            long cost = parent.cost;

            if (cost > bestFit[node]) {
                continue;
            }

            if (node == n - 1) {
                return true;
            }

            for (Pair neighbour : adj.get(node)) {

                if (neighbour.weight < midWeight) {
                    continue;
                }

                long newCost = cost + neighbour.weight;

                if (newCost <= k && newCost < bestFit[neighbour.v]) {
                    bestFit[neighbour.v] = newCost;
                    q.add(new SecondPair(neighbour.v, newCost));
                }
            }
        }

        return false;
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

class SecondPair {
    int v;
    long cost;

    public SecondPair(int v, long cost) {
        this.v = v;
        this.cost = cost;
    }
}