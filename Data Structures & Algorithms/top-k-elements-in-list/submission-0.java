class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n: nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        ArrayList<Integer>[] buckets = new ArrayList[nums.length+1];
        for(int num: map.keySet()) {
            int freq = map.get(num);
            if(buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(num);
        }
        int[] ans = new int[k];
        int ind = 0;
        for(int freq = nums.length; freq >= 1 && ind < k; freq--) {
            if(buckets[freq] != null) {
                for(int i = 0; i < buckets[freq].size(); i++) {
                    ans[ind++] = buckets[freq].get(i);
                    if(ind == k) break;
                }
            }
        }
        return ans;
    }
}
