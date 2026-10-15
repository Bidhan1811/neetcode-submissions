class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        solve(candidates, target, ans, new ArrayList<>(), 0);
        return ans;
    }
    public void solve(int[] nums, int target, List<List<Integer>> ans, List<Integer> temp, int i) {
        if(target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(i == nums.length || target < 0) return;
        temp.add(nums[i]);
        solve(nums, target - nums[i], ans, temp, i + 1);
        temp.remove(temp.size() - 1);
        int next = i + 1;
        while(next < nums.length && nums[next] == nums[i]) {
            next++;
        }
        solve(nums, target, ans, temp, next);
    }
}
