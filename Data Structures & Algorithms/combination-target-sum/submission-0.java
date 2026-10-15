class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(nums, target, ans, new ArrayList<>(), 0, 0);
        return ans;
    }
    public void solve(int[] nums, int target, List<List<Integer>> ans, List<Integer> temp, int i, int sum) {
        if(sum == target) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(sum > target || i == nums.length) return;
        temp.add(nums[i]);
        sum += nums[i];
        solve(nums, target, ans, temp, i, sum);
        sum -= temp.get(temp.size() - 1);
        temp.remove(temp.size() - 1);
        solve(nums, target, ans, temp, i+1, sum);
    }
}
