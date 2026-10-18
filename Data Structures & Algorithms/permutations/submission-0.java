class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] vis = new boolean[nums.length];
        solve(nums, ans, new ArrayList<>(), vis);
        return ans;
    }
    public void solve(int[] nums, List<List<Integer>> ans, List<Integer> temp, boolean[] vis) {
        if(temp.size() == nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(!vis[i]) {
                temp.add(nums[i]);
                vis[i] = true;
                solve(nums, ans, temp, vis);
                vis[i] = false;
                temp.remove(temp.size() - 1);
            }
        }
    }
}
