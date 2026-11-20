class Solution {
    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, -1, 0, 1};
    public int longestIncreasingPath(int[][] matrix) {
        int ans = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int[] r: dp) Arrays.fill(r, -1);
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                ans = Math.max(ans, dfs(matrix, i, j, dp));
            }
        }
        return ans;
    }
    public int dfs(int[][] matrix, int i, int j, int[][] dp) {
        if(i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int max = 1;
        for(int k = 0; k < 4; k++) {
            int nr = i + dr[k];
            int nc = j + dc[k];
            if(nr < 0 || nc < 0 || nr >= matrix.length || nc >= matrix[0].length) continue;
            else if(matrix[nr][nc] <= matrix[i][j]) continue;
            else max = Math.max(max, 1 + dfs(matrix, nr, nc, dp));
        }
        return dp[i][j] = max;
    }
}
