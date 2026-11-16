class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums) sum += num;
        Boolean[][] dp = new Boolean[nums.length][sum];
        if(sum % 2 != 0) return false;
        return solve(nums, sum, 0, 0, dp);
    }
    public boolean solve(int[] nums, int sum , int i, int currSum, Boolean[][] dp) {
        if(currSum == sum/2) return true;
        if(i >= nums.length) return false;
        if(dp[i][currSum] != null) return dp[i][currSum];
        boolean inc = false;
        if(currSum + nums[i] <= sum/2) inc = solve(nums, sum, i+1, currSum+nums[i], dp);
        boolean exc = solve(nums, sum, i+1, currSum, dp);
        return dp[i][currSum] = inc || exc;

    }
}
