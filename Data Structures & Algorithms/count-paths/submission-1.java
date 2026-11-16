class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++) dp[i][n-1] = 1;
        for(int i = 0; i < n; i++) dp[m-1][i] = 1;
        for(int i = m-2; i >= 0; i--) {
            for(int j = n-2; j >= 0; j--) {
                dp[i][j] = dp[i+1][j] + dp[i][j+1];
            }
        }
        return dp[0][0];
    }
    public int solve(int i, int j, int[][] dp, int m, int n) {
        if(i == m-1 && j == n-1) return 1;
        if(i >= m || j >= n || i < 0 || j < 0) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int down = solve(i+1, j, dp, m, n);
        int right = solve(i, j+1, dp, m, n);
        return dp[i][j] = down + right;
    }
}
