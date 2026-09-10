class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 1) return 1;
        int max = Integer.MIN_VALUE;
        HashSet<Integer> map = new HashSet<>();
        for(int n: nums) map.add(n);
        int ans = 0;
        for(int i = 0; i < nums.length; i++) {
            if(map.contains(nums[i] - 1)) ans++;
        }
        return ans;
    }
}
