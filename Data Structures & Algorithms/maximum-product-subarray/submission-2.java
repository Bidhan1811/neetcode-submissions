class Solution {
    public int maxProduct(int[] nums) {
        int maxP = nums[0];
        int minP = nums[0];
        int ans = nums[0];
        for(int i = 1; i < nums.length; i++) {
            int tempMax = maxP;
            int tempMin = minP;
            maxP = Math.max(nums[i], Math.max(nums[i] * tempMax, nums[i] * tempMin));
            minP = Math.min(nums[i], Math.min(nums[i] * tempMax, nums[i] * tempMin));
            ans = Math.max(ans, maxP);
        }
        return ans;
    }
}
