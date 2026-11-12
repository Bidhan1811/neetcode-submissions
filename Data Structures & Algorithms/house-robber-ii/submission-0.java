class Solution {
    public int rob(int[] nums) {
        int n= nums.length;
        if(n == 1) return nums[0];
        return Math.max(solve(nums, 0, n-2), solve(nums, 1, n-1));
    }
    public int solve(int[] nums, int start, int end) {
        int[] dp = new int[nums.length + 2];
        for(int i = end; i >= start; i--) {
            dp[i] = Math.max(nums[i] + dp[i+2], dp[i+1]);
        }
        return dp[start];
    }
}
