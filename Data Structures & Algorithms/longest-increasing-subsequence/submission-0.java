class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length][nums.length+1];
        for(int[] r: dp) Arrays.fill(r, -1);
        return solve(nums, 0, -1, dp);
    }
    public int solve(int[] nums, int i, int j, int[][] dp) {
        if(i == nums.length) return 0;
        if(dp[i][j+1] != -1) return dp[i][j+1];
        int inc = 0, exc = 0;
        if(j == -1 || nums[i] > nums[j]) inc = 1 + solve(nums, i+1, i, dp);
        exc = solve(nums, i+1, j, dp);
        return dp[i][j+1] = Math.max(inc, exc);
    }
}
