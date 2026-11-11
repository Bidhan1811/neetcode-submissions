class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        dp[n] = 0;
        dp[n-1] = cost[n-1];
        for(int i = n-2; i >= 0; i--) {
            dp[i] = cost[i] + Math.min(dp[i+1], dp[i+2]);
        }
        return Math.min(dp[0], dp[1]);
    }
    public int solve(int[] cost, int i, int[] dp) {
        if(i >= cost.length) return 0;
        if(dp[i] != -1) return dp[i];
        int cost1 = solve(cost, i+1, dp);
        int cost2 = solve(cost, i+2, dp);
        return dp[i] = Math.min(cost[i] + cost1, cost[i] + cost2);
    }
}
