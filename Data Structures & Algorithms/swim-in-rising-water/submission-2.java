class Solution {
    public int swimInWater(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                                (a, b) -> Integer.compare(a[0], b[0]));
        int maxTime = Integer.MAX_VALUE;
        int[][] vis = new int[m][n];
        pq.offer(new int[]{grid[0][0], 0, 0});
        vis[0][0] = grid[0][0];
        for(int[] row: vis) Arrays.fill(row, Integer.MAX_VALUE);
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, -1, 0, 1};
        while(!pq.isEmpty()) {
            int[] elem = pq.poll();
            int currMax = elem[0], i = elem[1], j = elem[2];
            if(i == m-1 && j == n-1) return currMax;
            for(int k = 0; k < 4; k++) {
                int nr = i + dr[k];
                int nc = j + dc[k];
                if(nr < 0 || nc < 0 || nr >= m || nc >= n) continue;
                int newMax = Math.max(currMax, grid[nr][nc]);

                if(newMax < vis[nr][nc]) {

                    vis[nr][nc] = newMax;

                    pq.offer(new int[]{newMax, nr, nc});
                }
            }
        }
        return maxTime;
    }
}
