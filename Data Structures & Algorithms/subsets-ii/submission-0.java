class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        solve(nums, ans, new ArrayList<>(), 0);
        return ans;
    }
    public void solve(int[] nums, List<List<Integer>> ans, List<Integer> temp, int idx) {
        ans.add(new ArrayList<>(temp));
        for(int i = idx; i < nums.length; i++) {
            if(i > idx && nums[i] == nums[i-1]) {
                continue;
            }
            temp.add(nums[i]);
            solve(nums, ans, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
