class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int num: nums) sum += num;
        int[][] dp = new int[nums.length][2*sum+1];
        for(int[] r: dp) Arrays.fill(r, -1);
        return solve(sum, nums, 0, target, 0, dp);
    }
    public int solve(int offset, int[] nums, int sum, int target, int i, int[][] dp) {
        if(i >= nums.length || i < 0) {
            if(sum == target) return 1;
            return 0;
        }
        if(dp[i][sum+offset] != -1) return dp[i][sum+offset];
        int plus = solve(offset, nums, sum + nums[i], target, i+1, dp);
        int minus = solve(offset, nums, sum - nums[i], target, i+1, dp);
        return dp[i][sum+offset] = plus + minus;
    }
}
