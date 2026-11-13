class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount + 1];
        for(int[] r: dp) Arrays.fill(r, -1);
        int ans = solve(coins, amount, 0, dp);
        return ans == Integer.MAX_VALUE ? -1: ans;
    }
    public int solve(int[] arr, int amt, int i, int[][] dp) {
        if(amt == 0) return 0;
        if(dp[i][amt] != -1) return dp[i][amt];
        int n = Integer.MAX_VALUE;
        for(int k = i; k < arr.length; k++) {
            if(amt - arr[k] < 0) continue;
            int next = solve(arr, amt-arr[k], k, dp);
            if(next != Integer.MAX_VALUE) n = Math.min(n, 1 + next);
        }
        return dp[i][amt] = n;
    }
}
