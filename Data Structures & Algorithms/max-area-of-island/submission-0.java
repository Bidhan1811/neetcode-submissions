class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int maxArea = 0;
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, -1, 0, 1};
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    int area = 1;
                    q.offer(new int[]{i, j});
                    grid[i][j] = 0;
                    while(!q.isEmpty()) {
                        int[] curr = q.poll();
                        int r = curr[0];
                        int c = curr[1];
                        for(int k = 0; k < 4; k++) {
                            int nr = r + dr[k];
                            int nc = c + dc[k];
                            if(nr < 0 || nc < 0 || nr >= m || nc >= n) continue;
                            if(grid[nr][nc] == 1) {
                                area++;
                                q.offer(new int[]{nr, nc});
                                grid[nr][nc] = 0;
                            }
                        }
                    }
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }
}
