class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, -1, 0, 1};
        int time = 0;
        int fresh = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                }
                else if(grid[i][j] == 1) fresh++;
            }
        }
        while(!q.isEmpty() && fresh > 0) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];
                for(int k = 0; k < 4; k++) {
                    int nr = r + dr[k];
                    int nc = c + dc[k];
                    if(nr < 0 || nc < 0 || nr >= m || nc >= n || grid[nr][nc] != 1) continue;
                   
                    grid[nr][nc] = 2;
                    q.offer(new int[]{nr, nc});
                    fresh--;
                    
                }
            }
            time++;
        }
        return fresh == 0 ? time : -1;
    }
}
