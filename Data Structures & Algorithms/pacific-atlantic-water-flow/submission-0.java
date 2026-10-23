class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        for(int i = 0; i < n; i++) {
            dfs(0, i, pacific, heights);
        }
        for(int i = 0; i < m; i++) {
            dfs(i, 0, pacific, heights);
        }
        for(int i = 0; i < n; i++) {
            dfs(m-1, i, atlantic, heights);
        }
        for(int i = 0; i < m; i++) {
            dfs(i, n-1, atlantic, heights);
        }
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }

        return ans;
    }
    public void dfs(int r, int c, boolean[][] vis, int[][] mat) {
        if(r < 0 || c < 0 || r >= mat.length || c >= mat[0].length || vis[r][c]) return;
        vis[r][c] = true;
        int[] dr = {-1, 0, 1, 0};  
        int[] dc = {0, -1, 0, 1};
        for(int k = 0; k < 4; k++) {
            int nr = r + dr[k];
            int nc = c + dc[k];
            if (nr < 0 || nc < 0 ||
                nr >= mat.length || nc >= mat[0].length) {
                continue;
            }
            if(!vis[nr][nc] && mat[nr][nc] >= mat[r][c])  {
                dfs(nr, nc, vis, mat);
            }
        }
    }
}
