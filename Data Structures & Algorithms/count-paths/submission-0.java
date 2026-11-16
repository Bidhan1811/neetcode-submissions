class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int[] r: dp) Arrays.fill(r, -1);
        return solve(0, 0, dp, m, n);
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
