class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount + 1];
        for(int[] r: dp) Arrays.fill(r, -1);
        int ans = solve(coins, amount, 0, dp);
        return ans;
    }
    public int solve(int[] arr, int amt, int i, int[][] dp) {
        if(amt == 0) return 1;
        if(dp[i][amt] != -1) return dp[i][amt];
        int ways = 0;
        for(int k = i; k < arr.length; k++) {
            if(amt - arr[k] < 0) continue;
            ways += solve(arr, amt-arr[k], k, dp);
        }
        return dp[i][amt] = ways;
    }
}
