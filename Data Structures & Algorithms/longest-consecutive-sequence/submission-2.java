class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 1) return 1;
        int max = Integer.MIN_VALUE;
        HashSet<Integer> map = new HashSet<>();
        for(int n: nums) map.add(n);
        int ans = 0;
        for(int i = 0; i < nums.length; i++) {
            int seq = 0;
            if(!map.contains(nums[i]-1)) {
                int num = nums[i];
                while(map.contains(num)) {
                    seq++;
                    num = num + 1;
                }
                ans = Math.max(ans, seq);
            }
            else continue;
        }
        return ans;
    }
}
