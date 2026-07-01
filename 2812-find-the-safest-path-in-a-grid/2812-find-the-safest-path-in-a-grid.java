class Solution {
    public int[] row = {0, 0, -1, 1};
    public int[] col = {-1, 1, 0, 0};
    public void SafenessFactor(List<List<Integer>> grid, int[][] score, int n) {
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    score[i][j] = 0;
                    q.offer(new int[]{i, j});
                }
            }
        }
        while (!q.isEmpty()) {
            int[] t = q.poll();
            int x = t[0], y = t[1];
            int s = score[x][y];

            for (int i = 0; i < 4; i++) {
                int a = x + row[i];
                int b = y + col[i];

                if (a >= 0 && a < n && b >= 0 && b < n && score[a][b] > 1 + s) {
                    score[a][b] = 1 + s;
                    q.offer(new int[]{a, b});
                }
            }
        }
    }

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        if (grid.get(0).get(0) == 1 || grid.get(n - 1).get(n - 1) == 1) {
            return 0;
        }

        int[][] score = new int[n][n];
        for (int[] row : score) Arrays.fill(row, Integer.MAX_VALUE);
        SafenessFactor(grid, score, n);
        // System.out.println(Arrays.deepToString(score));
        boolean[][] vis = new boolean[n][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        pq.offer(new int[]{score[0][0], 0, 0});
        while (!pq.isEmpty()) {
            int[] temp = pq.poll();
            int safe = temp[0];
            int i = temp[1], j = temp[2];

            if (i == n - 1 && j == n - 1) return safe;
            vis[i][j] = true;

            for (int k = 0; k < 4; k++) {
                int a = i + row[k];
                int b = j + col[k];

                if (a >= 0 && a < n && b >= 0 && b < n && !vis[a][b]) {
                    int s = Math.min(safe, score[a][b]);
                    pq.offer(new int[]{s, a, b});
                    vis[a][b] = true;
                }
            }
        }

        return 0;
    }
}