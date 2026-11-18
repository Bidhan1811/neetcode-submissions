class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for(int[] r: dp) Arrays.fill(r, -1);
        return solve(prices, 0, 1, dp);
    }
    public int solve(int[] nums, int i, int canBuy, int[][]dp) {
        if(i >= nums.length) return 0;
        if(dp[i][canBuy] != -1) return dp[i][canBuy];
        if(canBuy == 1) {
            int buy = -nums[i] + solve(nums, i+1, 0, dp);
            int skip = solve(nums, i+1, 1, dp);
            return dp[i][canBuy] = Math.max(buy, skip);
        }
        else {
            int sell = nums[i] + solve(nums, i+2, 1, dp);
            int skip = solve(nums, i+1, 0, dp);
            return dp[i][canBuy] = Math.max(sell, skip);
        }
    }
}
