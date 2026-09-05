class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        prefix[0] = height[0];
        suffix[n-1] = height[n-1];
        int max = prefix[0];
        for(int i = 1; i < n; i++) {
            if(height[i] > max) {
                prefix[i] = height[i];
                max = height[i];
            }
            else {
                prefix[i] = max;
            }
        }
        max = suffix[n-1];
        for(int i = n-2; i >= 0; i--) {
            if(height[i] > max) {
                suffix[i] = height[i];
                max = height[i];
            }
            else {
                suffix[i] = max;
            }
        }
        int ans = 0;
        for(int i = 0; i < n; i++) {
            ans += (Math.min(prefix[i], suffix[i]) - height[i]);
        }
        return ans;
    }
}
